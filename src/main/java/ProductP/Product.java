package ProductP;

import PersonP.SellerP.Freelance;
import PersonP.SellerP.Seller;
import javafx.scene.control.CheckBox;

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
    protected CheckBox checked;

    //Builders
    public Product(Seller productor, String season, double priceKg, int amount, String name) {
        this.productor = productor;
        this.season = season;
        this.priceKg = priceKg;
        this.amount = amount;
        this.name = name;
        this.checked =new CheckBox();
    }

    public Product() {
        this(new Freelance() , "", 0, 0,"");
    }

    //Getters and Setters
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

    public CheckBox getChecked() {
        return checked;
    }

    public void setChecked(CheckBox checked) {
        this.checked = checked;
    }

    //Methods

    /**
     * Method to obtain the location of the producer
     * (Metode per a obtindre la localització del productor)
     * @return the location of the producer
     */
    public String getProductorLocation() {
        if (productor != null) {
            return productor.getLocation();
        } else {
            return "Localización no disponible";
        }
    }


    //Override methods
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
