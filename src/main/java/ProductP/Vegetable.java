package ProductP;

import PersonP.SellerP.Freelance;
import PersonP.SellerP.Seller;

public class Vegetable extends Product{
    public Vegetable(Seller productor, String season, double priceKg, int amount, String name) {
        super(productor, season, priceKg, amount, name);
    }

    public Vegetable() {
        this(new Freelance() , "", 0, 0,"");
    }

    @Override
    public String toString() {
        return "Vegetable{} " + super.toString();
    }
}
