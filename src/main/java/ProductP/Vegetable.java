package ProductP;

import PersonP.SellerP.Freelance;
import PersonP.SellerP.Seller;
/**
 * Class for Vegetable
 * @author Pedro Sala Mora
 * @version 1
 */
public class Vegetable extends Product{

    /**
     * Constructor with parameters
     * @param productor A Seller With the vegetable productor
     * @param season A String with the vegetable season
     * @param priceKg A Double with the vegetable price
     * @param amount An int with the vegetable amount
     * @param name A String with the vegetable name
     */
    public Vegetable(Seller productor, String season, double priceKg, int amount, String name) {
        super(productor, season, priceKg, amount, name);
    }

    /**
     * Constructor without parameters
     */
    public Vegetable() {
        this(new Freelance() , "", 0, 0,"");
    }

    //Overrides Methods
    @Override
    public String toString() {
        return "Vegetable{} " + super.toString();
    }
}
