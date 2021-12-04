package integration.service;

import integration.domain.Order;

public class ShippingServiceNextDay {
	public Order printOrder(Order order) throws Exception {
        System.out.println("--- Ordered: In Next day ShippingService");
        System.out.println(order.toString());
        return order;
    }
}
