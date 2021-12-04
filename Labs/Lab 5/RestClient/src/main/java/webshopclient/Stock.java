package webshopclient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Stock {
    private int minStock;
    private int locationCode;

    public Stock() {}

    public Stock(int minStock, int locationCode) {
        this.minStock = minStock;
        this.locationCode = locationCode;
    }

    public int getMinStock() {
        return minStock;
    }

    public void setMinStock(int minStock) {
        this.minStock = minStock;
    }

    public int getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(int locationCode) {
        this.locationCode = locationCode;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "minStock='" + minStock + '\'' +
                ", locationCode='" + locationCode + '\'' +
                '}';
    }
}
