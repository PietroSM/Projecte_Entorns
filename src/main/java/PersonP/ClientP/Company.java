package PersonP.ClientP;

/**
 * Class for company
 * @author Pedro Sala Mora
 * @version 1
 */
public class Company extends Client{
    private String cif;

    //Builders
    public Company(String name, String password, String location,
                   String email, int id_Client, String cif) {
        super(name, password, location, email, id_Client);
        this.cif = cif;
    }

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
