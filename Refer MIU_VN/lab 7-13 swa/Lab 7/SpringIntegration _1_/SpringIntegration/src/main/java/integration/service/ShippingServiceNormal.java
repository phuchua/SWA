package integration.service;

import integration.domain.Order;

public class ShippingServiceNormal {
	public Order printOrder(Order order) throws Exception {
        System.out.println("--- Ordered: In Normal ShippingService");
        System.out.println(order.toString());
        return order;
    }
}
