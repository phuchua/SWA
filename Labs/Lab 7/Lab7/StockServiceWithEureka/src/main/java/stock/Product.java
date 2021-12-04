package stock;

public class Product {
	private String productNumber;
	private String name;
	private int numberOfStock;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(String productNumber, String name, int numberOfStock) {
		super();
		this.productNumber = productNumber;
		this.name = name;
		this.numberOfStock = numberOfStock;
	}

	public String getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumberOfStock() {
		return numberOfStock;
	}

	public void setNumberOfStock(int numberOfStock) {
		this.numberOfStock = numberOfStock;
	}
}
