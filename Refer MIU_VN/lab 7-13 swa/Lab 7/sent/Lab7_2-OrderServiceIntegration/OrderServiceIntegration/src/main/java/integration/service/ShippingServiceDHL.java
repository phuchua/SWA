package integration.service;

import integration.domain.Order;

public class ShippingServiceDHL {
	public Order printOrder(Order order) throws Exception {
        System.out.println("--- Ordered: by DHL ShippingService");
        System.out.println(order.toString());
        return order;
    }
}
