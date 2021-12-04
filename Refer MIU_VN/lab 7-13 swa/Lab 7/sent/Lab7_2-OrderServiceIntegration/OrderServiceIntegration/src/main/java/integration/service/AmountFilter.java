package integration.service;

import integration.domain.Order;

public class AmountFilter {
	public boolean checkTotalPrice(Order order) {
        if (order.getTotalPrice() >= 1.0) {
            return true;
        }
        return false;
    }
}
