package mytrader.model;

/**
 * Created by rajatkumar on 01/06/2020.
 */
public class Stock {
    private double price;
    private String securityName;
    private int volume;

    public Stock(final double price, final String securityName, final int volume) {
        this.price = price;
        this.securityName = securityName;
        this.volume = volume;

    }

    public double getPrice() {
        return price;
    }

    public void setPrice(final double price) {
        this.price = price;
    }

    public String getSecurityName() {
        return securityName;
    }

    public void setSecurityName(final String securityName) {
        this.securityName = securityName;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(final int volume) {
        this.volume = volume;
    }

}
