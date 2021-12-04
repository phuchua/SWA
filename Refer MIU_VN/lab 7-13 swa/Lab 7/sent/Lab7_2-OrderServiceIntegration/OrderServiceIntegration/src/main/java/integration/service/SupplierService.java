package integration.service;

import integration.domain.Order;

public class SupplierService {
	public Order print(Order order) throws Exception {
        System.out.println("--- SupplierService need more");
        System.out.println(order.toString());
        return order;
    }
}
