package webshopclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class RestClientApplication implements CommandLineRunner {
	@Autowired
	private RestOperations restTemplate;

	public static void main(String[] args) {
		SpringApplication.run(RestClientApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String serverUrl = "http://localhost:8080/product";

		// add a product: 1
		restTemplate.postForLocation(serverUrl, new Product("1", "IPhone 13 Pro Max", 1299.99,
				new Supplier("11","Apple","702-881-4545","supplier1@gmail.com", new Address("19002 Dallas Pkwy","Dallas",75287,"USA")),
				new Stock(100000, 75287)));
		// add a product: 2
		restTemplate.postForLocation(serverUrl, new Product("2", "Samsung S21 Ultra", 1199.00,
				new Supplier("22","Samsung","702-881-3399","supplier2@gmail.com", new Address("1000 Plano Pkwy","Plano",75345,"USA")),
				new Stock(5000, 75345)));

		// get a product: 1
		Product product1 = restTemplate.getForObject(serverUrl + "/{productNumber}", Product.class, "1");
		System.out.println("------- get product 1 -------");
		System.out.println(product1.toString());

		Product product2 = restTemplate.getForObject(serverUrl + "/{productNumber}", Product.class, "2");
		System.out.println("------- get product 2 -------");
		System.out.println(product2.toString());

		serverUrl = "http://localhost:8080/shopping";
		// add to shopping cart
		List<CartLine> lstCartLine1 = new ArrayList<CartLine>() {{
			add(new CartLine("line1", product1));
		}};
		restTemplate.postForLocation(serverUrl, new ShoppingCart("shoppingcart1", lstCartLine1));

		List<CartLine> lstCartLine2 = new ArrayList<CartLine>() {{
			add(new CartLine("line2", product2));
		}};
		restTemplate.postForLocation(serverUrl, new ShoppingCart("shoppingcart2", lstCartLine2));

		List<CartLine> lstCartLine3 = new ArrayList<CartLine>() {{
			add(new CartLine("line3", product1));
			add(new CartLine("line3", product2));
		}};
		restTemplate.postForLocation(serverUrl, new ShoppingCart("shoppingcart3", lstCartLine3));

		// get shopping cart
		ShoppingCart shoppingcartResult = restTemplate.getForObject(serverUrl + "/{shoppingCartNumber}", ShoppingCart.class, "shoppingcart3");
		System.out.println("------- get shopping cart -------");
		System.out.println(shoppingcartResult.toString());
	}


	@Bean
	RestOperations restTemplate()
	{
		return new RestTemplate();
	}
}
