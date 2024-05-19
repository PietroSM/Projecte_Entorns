package PersonP.SellerP;

/**
 * Class for Freelance
 * @author Pedro Sala Mora
 * @version 1
 */
public class Freelance extends Seller{

    /**
     * Constructor with parameters
     * @param name A String with the Freelance name
     * @param password A String with the Freelance password
     * @param location A String with the Freelance location
     * @param email A String with the Freelance email
     * @param id_Seller AN int with Freelance id_Seller
     * @param cif A String with Freelance CIF
     */
    public Freelance(String name, String password, String location, String email,
                     int id_Seller, String cif) {
        super(name, password, location, email, id_Seller, cif);
    }

    /**
     * Constructor without parameters
     */
    public Freelance() {
        this("","","","",0,"");
    }

    //Overrides methods
    @Override
    public String toString() {
        return "Freelance{} " + super.toString();
    }
}
