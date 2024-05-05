package ProductP;

import PersonP.SellerP.Freelance;
import PersonP.SellerP.Seller;

public class Fruit extends Product{

    public Fruit(Seller productor, String season, double priceKg, int amount, String name) {
        super(productor, season, priceKg, amount, name);
    }

    public Fruit() {
        this(new Freelance() , "", 0, 0,"");
    }

    @Override
    public String toString() {
        return "Fruit{} " + super.toString();
    }
}
