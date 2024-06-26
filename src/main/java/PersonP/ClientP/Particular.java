package PersonP.ClientP;

/**
 * Class for particular
 * @author Pedro Sala Mora
 * @version 1
 */
public class Particular extends Client{
    private String dni;

    /**
     * Constructor with parameters
     * @param name A String with the Particular name
     * @param password A String with the Particular password
     * @param location A String with the Particular location
     * @param email A String with the Particular email
     * @param id_Client An int with the Particular id_Client
     * @param dni A String with the Particular DNI
     */
    public Particular(String name, String password, String location,
                      String email, int id_Client, String dni) {
        super(name, password, location, email, id_Client);
        this.dni = dni;
    }

    /**
     * Constructor without parameters
     */
    public Particular() {
        this("","","","",0,"");
    }

    //Getters and Setters
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    //Overrides methods
    @Override
    public String toString() {
        return "Particular{" +
                "dni='" + dni + '\'' +
                "} " + super.toString();
    }
}
