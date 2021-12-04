package webshopclient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {

    private String productNumber;
    private String description;
    private Double price;
    private Supplier supplier;
    private Stock stock;

    public Product() {

    }

    public Product(String productNumber, String description, Double price, Supplier supplier, Stock stock) {
        this.productNumber = productNumber;
        this.description = description;
        this.price = price;
        this.supplier = supplier;
        this.stock = stock;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productNumber='" + productNumber + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", supplier=" + supplier +
                ", stock=" + stock +
                '}';
    }
}