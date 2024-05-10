package PersonP.SellerP;

/**
 * Class for Freelance
 * @author Pedro Sala Mora
 * @version 1
 */
public class Freelance extends Seller{

    /**Builders*/
    public Freelance(String name, String password, String location, String email,
                     int id_Seller, String cif) {
        super(name, password, location, email, id_Seller, cif);
    }

    public Freelance() {
        this("","","","",0,"");
    }

    /**Overrides methods*/
    @Override
    public String toString() {
        return "Freelance{} " + super.toString();
    }
}
