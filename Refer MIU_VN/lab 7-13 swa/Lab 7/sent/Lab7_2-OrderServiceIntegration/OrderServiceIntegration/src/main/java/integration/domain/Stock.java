package integration.domain;

public class Stock {
	int quantity;
    String locationCode;
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getLocationCode() {
		return locationCode;
	}
	public void setLocationCode(String locationCode) {
		this.locationCode = locationCode;
	}
	public Stock(int quantity, String locationCode) {
		super();
		this.quantity = quantity;
		this.locationCode = locationCode;
	}
	
	@Override
	public String toString() {
		return "Stock [quantity=" + quantity + ", locationCode=" + locationCode + "]";
	}

	public void print() {
        System.out.println("Stock quantity: " + quantity + " ,location code : " + locationCode);
    }
	
}
