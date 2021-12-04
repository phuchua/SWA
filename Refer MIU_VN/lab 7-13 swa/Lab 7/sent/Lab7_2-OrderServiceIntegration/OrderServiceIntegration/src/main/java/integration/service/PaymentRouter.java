package integration.service;

import integration.domain.Order;


public class PaymentRouter {
	
	public String route(Order order) throws Exception {
		boolean paymentDefined = true;
		String destChannel = null;
		if (paymentDefined) {
			destChannel = "paymentSuccessful";
		} else {
			destChannel = "paymentFail";
		}
		return destChannel;
	}
	

}
