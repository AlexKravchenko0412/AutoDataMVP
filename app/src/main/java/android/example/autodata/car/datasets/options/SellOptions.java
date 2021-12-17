package android.example.autodata.car.datasets.options;

public class SellOptions {
    private String price;
    private String marketPrice;
    private String personPrice;

    public SellOptions(String price, String marketPrice, String personPrice) {
        this.price = price;
        this.marketPrice = marketPrice;
        this.personPrice = personPrice;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(String marketPrice) {
        this.marketPrice = marketPrice;
    }

    public String getPersonPrice() {
        return personPrice;
    }

    public void setPersonPrice(String personPrice) {
        this.personPrice = personPrice;
    }
}
