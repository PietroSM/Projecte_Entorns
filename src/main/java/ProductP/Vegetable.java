package ProductP;

import PersonP.SellerP.Freelance;
import PersonP.SellerP.Seller;

public class Vegetable extends Product{
    public Vegetable(Seller productor, String season, double priceKg, int amount) {
        super(productor, season, priceKg, amount);
    }

    public Vegetable() {
        this(new Freelance() , "", 0, 0);
    }

    @Override
    public String toString() {
        return "Vegetable{} " + super.toString();
    }
}
