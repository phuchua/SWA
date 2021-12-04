package integration.service;

import integration.domain.Order;


public class StockService {
	

	public Order printStock(Order order) throws Exception {
        System.out.println("--- In StockService");
        System.out.println(order.toString());
        return order;
    }
	
	public boolean checkStock(Order order) throws Exception {
        return true;
    } 
}
