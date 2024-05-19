package PersonP.SellerP;

import PersonP.Person;
/**
 * Abstract class used as a template for Seller users
 * @author Pedro Sala Mora
 * @version 1
 */
public abstract class Seller extends Person {
    protected int id_Seller;
    protected String cif;

    /**
     * Constructor with parameters
     * @param name A String with the seller name
     * @param password A String with the seller password
     * @param location A String with the seller location
     * @param email A String with the seller email
     * @param id_Seller AN int with seller id_Seller
     * @param cif A String with seller CIF
     */
    public Seller(String name, String password, String location, String email,
                  int id_Seller, String cif) {
        super(name, password, location, email);
        this.id_Seller = id_Seller;
        this.cif = cif;
    }

    /**
     * Constructor without parameters
     */
    public Seller() {
        this("","","","",0,"");
    }

    //Getters and Setters
    public int getId_Seller() {
        return id_Seller;
    }

    public void setId_Seller(int id_Seller) {
        this.id_Seller = id_Seller;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    //Overides Methods
    @Override
    public String toString() {
        return "Seller{" +
                "id_Seller=" + id_Seller +
                ", cif='" + cif + '\'' +
                "} " + super.toString();
    }
}
