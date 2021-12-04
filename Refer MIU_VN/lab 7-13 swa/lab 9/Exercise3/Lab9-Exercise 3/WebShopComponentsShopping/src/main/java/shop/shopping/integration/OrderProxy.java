package shop.shopping.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestOperations;

import shop.shopping.service.ShoppingCartDTO;

@Component
public class OrderProxy {
	/*
	@Autowired
	private RestOperations restTemplate;
	@Value("${ordersURL}")
	String ordersURL;

	public void createOrder(ShoppingCartDTO shoppingCartDTO) {		
		restTemplate.postForLocation(ordersURL+"/order/create", shoppingCartDTO);		
	};
	
	*/
	
	
	@Autowired
	OrderFeignClient orderClient;
	
	public void createOrder(ShoppingCartDTO shoppingCartDTO) {
		//OrderCustomerDTO customer = restTemplate.getForObject(customersURL+"/ordercustomer/"+customerNumber, OrderCustomerDTO.class);
		orderClient.createOrder(shoppingCartDTO);
	};


	
	@FeignClient("orderservice")
	//@RibbonClient(name = "orderservice")
	interface OrderFeignClient {
		@PostMapping("/order/create")
		public void createOrder(@RequestBody ShoppingCartDTO shoppingCartDTO);
	}
}
