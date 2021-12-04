package integration.service;

import integration.domain.Order;

public class OrderService {
	public void handle(Order order) {
		System.out.println("OrderService receiving order: " + order.toString());
	}
	
	public void handleFail(Order order) {
		System.out.println("OrderService receiving fail " + order.toString());
	}



	
}
