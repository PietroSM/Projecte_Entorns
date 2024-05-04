package ProductP;

import PersonP.SellerP.Freelance;
import PersonP.SellerP.Seller;

public class Fruit extends Product{

    public Fruit(Seller productor, String season, double priceKg, int amount) {
        super(productor, season, priceKg, amount);
    }

    public Fruit() {
        this(new Freelance() , "", 0, 0);
    }

    @Override
    public String toString() {
        return "Fruit{} " + super.toString();
    }
}
