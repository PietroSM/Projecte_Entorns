package ProductP;

import PersonP.SellerP.Freelance;
import PersonP.SellerP.Seller;

public abstract class Product {
    protected Seller productor;
    protected String name;
    protected String season;
    protected double priceKg;
    protected int amount;

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

    @Override
    public String toString() {
        return "Product{" +
                "productor=" + productor +
                ", name='" + name + '\'' +
                ", season='" + season + '\'' +
                ", priceKg=" + priceKg +
                ", amount=" + amount +
                '}';
    }
}
