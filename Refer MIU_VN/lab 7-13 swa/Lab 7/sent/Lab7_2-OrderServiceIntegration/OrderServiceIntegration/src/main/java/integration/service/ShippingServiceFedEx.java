package integration.service;

import integration.domain.Order;

public class ShippingServiceFedEx {
	public Order printOrder(Order order) throws Exception {
        System.out.println("--- Ordered: by FedEx ShippingService");
        System.out.println(order.toString());
        return order;
    }
}
