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
import org.springframework.web.client.RestOperations;

import shop.shopping.integration.OrderProxy.OrderFeignClient;
import shop.shopping.service.ProductDTO;
import shop.shopping.service.ShoppingCartDTO;

@Component
public class ProductCatalogProxy {
	/*
	@Autowired
	private RestOperations restTemplate;
	@Value("${productsURL}")
	String productsURL;
	
	public ProductDTO getProduct(String productnumber) {
		ProductDTO product = restTemplate.getForObject(productsURL+"/product/A33", ProductDTO.class);
		return product;
	};
	
	*/
	
	@Autowired
	ProductFeignClient productClient;
	
	public ProductDTO getProduct(String productnumber) {
		//ProductDTO product = restTemplate.getForObject(productsURL+"/product/A33", ProductDTO.class);
		ProductDTO product = (ProductDTO) productClient.getContact(productnumber).getBody();
		//ProductDTO product = productClient.getContact("A33").getBody();
		return product;
	}



	
	@FeignClient("productservice")
	//@RibbonClient(name = "productservice")
	interface ProductFeignClient {
		@GetMapping("/product/{productnumber}")
		public ResponseEntity<ProductDTO> getContact(@PathVariable("productnumber") String productnumber);
	}
}
