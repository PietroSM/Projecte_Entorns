package ProductP;

import PersonP.SellerP.Freelance;
import PersonP.SellerP.Seller;

/**
 * Class for Fruit
 * @author Pedro Sala Mora
 * @version 1
 */
public class Fruit extends Product{

    //Builders
    public Fruit(Seller productor, String season, double priceKg, int amount, String name) {
        super(productor, season, priceKg, amount, name);
    }

    public Fruit() {
        this(new Freelance() , "", 0, 0,"");
    }

    //Overrides methods
    @Override
    public String toString() {
        return "Fruit{} " + super.toString();
    }
}
