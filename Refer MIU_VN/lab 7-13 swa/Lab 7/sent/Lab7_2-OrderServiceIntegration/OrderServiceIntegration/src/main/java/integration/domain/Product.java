package integration.domain;

public class Product {
	private String productnumber;
    private String name;
    private double price;
    private Stock stock;
    
    public Product(String productnumber, String name, double price, Stock stock) {
		super();
		this.productnumber = productnumber;
		this.name = name;
		this.price = price;
		this.stock = stock;
	}
    
    
    public Product(String productnumber, String name, double price) {
		super();
		this.productnumber = productnumber;
		this.name = name;
		this.price = price;
	}
    
    
	public String getProductnumber() {
		return productnumber;
	}
	public void setProductnumber(String productnumber) {
		this.productnumber = productnumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Stock getStock() {
		return stock;
	}
	public void setStock(Stock stock) {
		this.stock = stock;
	}


	@Override
	public String toString() {
		return "Product [productnumber=" + productnumber + ", name=" + name + ", price=" + price + ", stock=" + stock
				+ "]";
	}
	
    
}
