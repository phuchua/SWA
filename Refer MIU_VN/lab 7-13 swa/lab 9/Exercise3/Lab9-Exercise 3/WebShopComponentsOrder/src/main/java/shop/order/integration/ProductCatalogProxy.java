package shop.order.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestOperations;


@Component
public class ProductCatalogProxy {
	/*
	@Autowired
	private RestOperations restTemplate;
	@Value("${productsURL}")
	String productsURL;
	
	public void updateStock(String productNumber, int quantity) {
		restTemplate.postForLocation(productsURL+"/updateStock/"+productNumber+"/"+quantity, null);
	};
	
	*/
	
	@Autowired
	ProductFeignClient productClient;
	
	public void updateStock(String productNumber, int quantity) {
		//restTemplate.postForLocation(productsURL+"/updateStock/"+productNumber+"/"+quantity, null);
		productClient.updateStock(productNumber, quantity);
	}



	
	@FeignClient("productservice")
	interface ProductFeignClient {
		@PostMapping(value = "/product/updatestock/{productnumber}/{quantity}")
		public ResponseEntity<?> updateStock(@PathVariable("productnumber") String productnumber, @PathVariable("quantity") int quantity);
	}
}
