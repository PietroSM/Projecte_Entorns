package ProductP;

import PersonP.SellerP.Freelance;
import PersonP.SellerP.Seller;
/**
 * Class for VegetableLeafy
 * @author Pedro Sala Mora
 * @version 1
 */
public class VegetableLeafy extends Product{

    //Builders
    public VegetableLeafy(Seller productor, String season, double priceKg, int amount, String name) {
        super(productor, season, priceKg, amount, name);
    }

    public VegetableLeafy() {
        this(new Freelance() , "", 0, 0,"");
    }


    //Overrides methods
    @Override
    public String toString() {
        return "VegetableLeafy{} " + super.toString();
    }
}
