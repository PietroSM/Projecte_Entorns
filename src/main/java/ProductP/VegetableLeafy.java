package ProductP;

import PersonP.SellerP.Freelance;
import PersonP.SellerP.Seller;
/**
 * Class for VegetableLeafy
 * @author Pedro Sala Mora
 * @version 1
 */
public class VegetableLeafy extends Product{

    /**
     * Constructor with parameters
     * @param productor A Seller With the vegetableLeafy productor
     * @param season A String with the vegetableLeafy season
     * @param priceKg A Double with the vegetableLeafy price
     * @param amount An int with the vegetableLeafy amount
     * @param name A String with the vegetableLeafy name
     */
    public VegetableLeafy(Seller productor, String season, double priceKg, int amount, String name) {
        super(productor, season, priceKg, amount, name);
    }

    /**
     * Constructor without parameters
     */
    public VegetableLeafy() {
        this(new Freelance() , "", 0, 0,"");
    }


    //Overrides methods
    @Override
    public String toString() {
        return "VegetableLeafy{} " + super.toString();
    }
}
