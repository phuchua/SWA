package integration.service;

import integration.domain.Order;

public class ShippingService {
	public String route(Order order) {
        String destChannel;
        
        if (order.getAmount() > 175) {
        	destChannel = "nextdayshippingchannel";
        } else {            
            destChannel = "normalshippingchannel";
        }
        return destChannel;
    }
}
