package ProductP;

import PersonP.SellerP.Freelance;
import PersonP.SellerP.Seller;
/**
 * Class for Vegetable
 * @author Pedro Sala Mora
 * @version 1
 */
public class Vegetable extends Product{

    /**Builders*/
    public Vegetable(Seller productor, String season, double priceKg, int amount, String name) {
        super(productor, season, priceKg, amount, name);
    }

    public Vegetable() {
        this(new Freelance() , "", 0, 0,"");
    }

    /**Overrides Methods*/
    @Override
    public String toString() {
        return "Vegetable{} " + super.toString();
    }
}
