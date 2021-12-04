package webshopclient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ShoppingCart {
    private String shoppingCartNumber;
    private List<CartLine> listCartLine;

    public ShoppingCart() {}

    public ShoppingCart(String shoppingCartNumber, List<CartLine> listCartLine) {
        this.shoppingCartNumber = shoppingCartNumber;
        this.listCartLine = listCartLine;
    }

    public String getShoppingCartNumber() {
        return shoppingCartNumber;
    }

    public void setShoppingCartNumber(String shoppingCartNumber) {
        this.shoppingCartNumber = shoppingCartNumber;
    }

    public List<CartLine> getListCartLine() {
        return listCartLine;
    }

    public void setListCartLine(List<CartLine> listCartLine) {
        this.listCartLine = listCartLine;
    }

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "shoppingCartNumber='" + shoppingCartNumber + '\'' +
                ", listCartLine='" + listCartLine +
                '}';
    }
}
