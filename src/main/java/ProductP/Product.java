package ProductP;

import PersonP.SellerP.Freelance;
import PersonP.SellerP.Seller;

/**
 * abstract class that works as a template for the different products
 * @author Pedro Sala Mora
 * @version 1
 */
public abstract class Product {
    protected Seller productor;
    protected String name;
    protected String season;
    protected double priceKg;
    protected int amount;

    /**Builders*/
    public Product(Seller productor, String season, double priceKg, int amount, String name) {
        this.productor = productor;
        this.season = season;
        this.priceKg = priceKg;
        this.amount = amount;
        this.name = name;
    }

    public Product() {
        this(new Freelance() , "", 0, 0,"");
    }

    /**Getters and Setters*/
    public Seller getProductor() {
        return productor;
    }

    public void setProductor(Seller productor) {
        this.productor = productor;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public double getPriceKg() {
        return priceKg;
    }

    public void setPriceKg(double priceKg) {
        this.priceKg = priceKg;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    /**Override methods*/
    @Override
    public String toString() {
        return "Product{" +
                "productor=" + productor.getName() +
                ", name='" + name + '\'' +
                ", season='" + season + '\'' +
                ", priceKg=" + priceKg +
                ", amount=" + amount +
                '}';
    }
}
