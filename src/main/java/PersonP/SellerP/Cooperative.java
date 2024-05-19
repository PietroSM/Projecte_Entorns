package PersonP.SellerP;
/**
 * Class for Cooperative
 * @author Pedro Sala Mora
 * @version 1
 */
public class Cooperative extends Seller{

    /**
     * Constructor with parameters
     * @param name A String with the Cooperative name
     * @param password A String with the Cooperative password
     * @param location A String with the Cooperative location
     * @param email A String with the Cooperative email
     * @param id_Seller AN int with Cooperative id_Seller
     * @param cif A String with Cooperative CIF
     */
    public Cooperative(String name, String password, String location, String email,
                       int id_Seller, String cif) {
        super(name, password, location, email, id_Seller, cif);
    }

    /**
     * Constructor without parameters
     */
    public Cooperative() {
        this("","","","",0,"");
    }

    //Overrides
    @Override
    public String toString() {
        return "Cooperative{} " + super.toString();
    }
}
