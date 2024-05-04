package ProductP;

import PersonP.SellerP.Freelance;
import PersonP.SellerP.Seller;

public class VegetableLeafy extends Product{
    public VegetableLeafy(Seller productor, String season, double priceKg,
                          int amount) {
        super(productor, season, priceKg, amount);
    }

    public VegetableLeafy() {
        this(new Freelance() , "", 0, 0);
    }

    @Override
    public String toString() {
        return "VegetableLeafy{} " + super.toString();
    }
}
