package integration.domain;

public class Order {
	private String ordernumber;
    private int amount;

    public Order(String ordernumber, int amount) {
        this.ordernumber = ordernumber;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getOrdernumber() {
        return ordernumber;
    }

    public void setOrdernumber(String ordernumber) {
        this.ordernumber = ordernumber;
    }

	@Override
	public String toString() {
		return "Order [ordernumber=" + ordernumber + ", amount=" + amount + "]";
	}
    
    
}
