package integration.service;

import integration.domain.Order;

public class ShippingRouter {
	public String route(Order order) {
		String channel=null;
		
		if (order.getShipper().equals("DHL")) {
			channel = "shippingDHL";
        }
        else if (order.getShipper().equals("FedEx")) {
        	channel = "shippingFedEx";
        }
		return channel;
    }
}
