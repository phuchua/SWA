package shop.order.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestOperations;

import shop.order.service.OrderCustomerDTO;



@Component
public class CustomerProxy {
/*	@Autowired
	private RestOperations restTemplate;
	@Value("${customersURL}")
	String customersURL;
	
	public OrderCustomerDTO getOrderCustomer(String customerNumber) {
		OrderCustomerDTO customer = restTemplate.getForObject(customersURL+"/ordercustomer/"+customerNumber, OrderCustomerDTO.class);
		return customer;	
	};
	*/
	
	@Autowired
	CustomerFeignClient customerClient;

	public OrderCustomerDTO getOrderCustomer(String customerNumber) {		
		OrderCustomerDTO customer = customerClient.getCustomer(customerNumber).getBody();
		return customer;
	};

	
	@FeignClient("customerservice")
	//@RibbonClient(name = "customerservice")
	interface CustomerFeignClient {
		@RequestMapping("/customer/{customerNumber}")
		public ResponseEntity<OrderCustomerDTO> getCustomer(@PathVariable("customerNumber") String customerNumber);
	}
	
}



