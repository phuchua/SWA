package integration.service;

import integration.domain.Order;

public class StockRouter {
	public String route(Order order) throws Exception {
		StockService stockProxy = new StockService();
		boolean isInStock = stockProxy.checkStock(order);
		String destChannel = null;
		if (isInStock) {
			destChannel = "payment";
		} else {
			destChannel = "supplier";
		}
		return destChannel;
	}
}
