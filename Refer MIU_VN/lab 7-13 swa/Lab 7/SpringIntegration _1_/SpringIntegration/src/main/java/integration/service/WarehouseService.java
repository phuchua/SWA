package integration.service;

import integration.domain.Order;

public class WarehouseService {
	public Order printOrder(Order order) throws Exception {
        System.out.println("--- In WarehouseService");
        System.out.println(order.toString());
        return order;
    }
}
