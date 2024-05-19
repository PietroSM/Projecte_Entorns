package PersonP.ClientP;

/**
 * Class for company
 * @author Pedro Sala Mora
 * @version 1
 */
public class Company extends Client{
    private String cif;

    /**
     * Constructor with parameters
     * @param name A String with the Company name
     * @param password A String with the Company password
     * @param location A String with the Company location
     * @param email A String with the Company email
     * @param id_Client An int with the Company id_Client
     * @param cif A String with the Company CIF
     */
    public Company(String name, String password, String location,
                   String email, int id_Client, String cif) {
        super(name, password, location, email, id_Client);
        this.cif = cif;
    }

    /**
     * Constructor without parameters
     */
    public Company() {
        this("","","","",0,"");
    }

    //Getters and Setters
    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }
}
