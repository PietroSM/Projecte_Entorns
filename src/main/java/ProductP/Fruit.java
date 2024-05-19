package ProductP;

import PersonP.SellerP.Freelance;
import PersonP.SellerP.Seller;

/**
 * Class for Fruit
 * @author Pedro Sala Mora
 * @version 1
 */
public class Fruit extends Product{

    /**
     * Constructor with parameters
     * @param productor A Seller With the fruit productor
     * @param season A String with the fruit season
     * @param priceKg A Double with the fruit price
     * @param amount An int with the fruit amount
     * @param name A String with the fruit name
     */
    public Fruit(Seller productor, String season, double priceKg, int amount, String name) {
        super(productor, season, priceKg, amount, name);
    }

    /**
     * Constructor without parameters
     */
    public Fruit() {
        this(new Freelance() , "", 0, 0,"");
    }

    //Overrides methods
    @Override
    public String toString() {
        return "Fruit{} " + super.toString();
    }
}
