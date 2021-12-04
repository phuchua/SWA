package stock;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StockController {

	@RequestMapping("/stock/{productNumber}")
	public Product getProduct(@PathVariable("productNumber") String productNumber) {

		switch (productNumber) {
			case "1":
				return new Product("1", "IPhone 13 Pro Max", 1200);
			case "2":
				return new Product("2", "Samsung Galaxy Note", 2000);
			default:
				return null;
		}
	}
}
