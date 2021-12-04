package integration.service;

import integration.domain.Order;


public class PaymentService {
	

	public boolean printPayment(Order order) throws Exception {
        System.out.println("--- In Payment service");
        System.out.println(order.toString());
        return true;
    }
	
	public void printPaymentFail(Order order) throws Exception {
        System.out.println("--- In Payment service Fail");
        System.out.println(order.toString());
    }

}
