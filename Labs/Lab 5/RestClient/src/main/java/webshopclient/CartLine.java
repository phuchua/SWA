package webshopclient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CartLine {
    private String cartLineNumber;
    private Product product;

    public CartLine() {}

    public CartLine(String cartLineNumber, Product product) {
        this.cartLineNumber = cartLineNumber;
        this.product = product;
    }

    public String getCartLineNumber() {
        return cartLineNumber;
    }

    public void setCartLineNumber(String cartLineNumber) {
        this.cartLineNumber = cartLineNumber;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "CartLine{" +
                "cartLineNumber='" + cartLineNumber + '\'' +
                ", product='" + product +
                '}';
    }
}
