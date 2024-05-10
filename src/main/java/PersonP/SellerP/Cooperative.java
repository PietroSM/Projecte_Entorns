package PersonP.SellerP;
/**
 * Class for Cooperative
 * @author Pedro Sala Mora
 * @version 1
 */
public class Cooperative extends Seller{

    /**Builders*/
    public Cooperative(String name, String password, String location, String email,
                       int id_Seller, String cif) {
        super(name, password, location, email, id_Seller, cif);
    }

    public Cooperative() {
        this("","","","",0,"");
    }

    /**Overrides*/
    @Override
    public String toString() {
        return "Cooperative{} " + super.toString();
    }
}
