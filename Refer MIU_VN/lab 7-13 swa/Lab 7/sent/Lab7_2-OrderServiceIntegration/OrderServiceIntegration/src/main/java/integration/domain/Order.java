package integration.domain;

import java.util.HashMap;
import java.util.Map;

public class Order {
	private String orderNumber;    
    private double totalPrice;
    private String shipper;
    private Map<String, Integer> orderlines;
    
    public Order(String ordernumber) {
        this.orderNumber = ordernumber;     
        this.orderlines = new HashMap<>();
    }

     
    public String getOrderNumber() {
		return orderNumber;
	}


	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}


	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}


	@Override
	public String toString() {
		return "Order [ordernumber=" + orderNumber + ", totalPrice=" + totalPrice +  "]";
	}

	public void setOrderlines(Map<String, Integer> orderlines) {
        this.orderlines = orderlines;
    }

	public void addOrderline(String productnumber, int quantity) {
		for (Map.Entry orderLine : orderlines.entrySet()) {
            if (productnumber.equals(orderLine.getKey())) {
                orderlines.put(productnumber, (Integer) orderLine.getValue() + quantity);
                return;
            }
        }

        orderlines.put(productnumber, quantity);
	}


	public String getShipper() {
        return shipper;
    }

    public void setShipper(String shipper) {
        this.shipper = shipper;
    }
	
    
}
