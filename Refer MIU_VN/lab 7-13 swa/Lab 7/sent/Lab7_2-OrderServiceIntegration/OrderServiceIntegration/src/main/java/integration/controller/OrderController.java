package integration.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import integration.domain.Order;
import integration.domain.Product;
import integration.domain.Stock;
import integration.gateway.OrderGateway;
import integration.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	@Autowired
	OrderService orderService;
	
	@Autowired
	private OrderGateway orderGateway;
	
	private static List<Product> products = new ArrayList<Product>();
	private static List<Order> orders = new ArrayList<Order>();
	   
    //data
	Product p1 = new Product("001", "Dell Inspiron 14", 950, new Stock(10, "ST001"));    
    Product p2 = new Product("002", "HP Laptop", 800, new Stock(20, "ST002"));       
    Product p3 = new Product("003", "Gateway Y2021", 700, new Stock(30, "ST002"));
    

    @PostMapping("/create/{ordernumber}")
	public Order createOrder(@PathVariable("ordernumber") String ordernumber) {
    	addDefaultProducts();
    	return createOrderFunc(ordernumber);
	}

    private void addDefaultProducts(){
    	orders.clear();
    	products.add(p1);
        products.add(p2);
        products.add(p3);
    }
    
	private Order createOrderFunc(String ordernumber) {
		Order order = new Order(ordernumber);
		orders.add(order);
		return order;
	}

	@PostMapping("/{ordernumber}/products/{productnumber}/{quantity}")
	public Order addProduct(@PathVariable("ordernumber") String ordernumber,
							@PathVariable("productnumber") String productnumber,
							@PathVariable("quantity") int quantity) {
		return addProductFunc(ordernumber, productnumber, quantity);
	}

	private Order addProductFunc(String ordernumber, String productnumber, int quantity) {
		Order order = orders.stream().filter(o -> o.getOrderNumber().equals(ordernumber)).findAny().get();
		Product product = products.stream().filter(p -> p.getProductnumber().equals(productnumber)).findAny().get();
		
		if (order != null && product != null) {
            order.addOrderline(productnumber, quantity);
        }
        else if (product != null) {
            order = createOrder(ordernumber);
            order.addOrderline(productnumber, quantity);
        }
		order.setTotalPrice(quantity * product.getPrice());
        return order;
	}

	@PostMapping("/{ordernumber}/shipper/{shipper}")
	public Order addProduct(@PathVariable("ordernumber") String ordernumber,
							@PathVariable("shipper") String shipper) {
		Order order = orders.stream().filter(o -> o.getOrderNumber().equals(ordernumber)).findAny().get();
		if (order != null) {
            order.setShipper(shipper);
        }
        return order;
	}

	@GetMapping("/{ordernumber}")
	public Order sendOrder(@PathVariable("ordernumber") String ordernumber) {
		Order order = orders.stream().filter(o -> o.getOrderNumber().equals(ordernumber)).findAny().get();
		Message<Order> orderMessage =  MessageBuilder.withPayload(order).build();
		return orderGateway.handleRequest(orderMessage);
	}
    
}
