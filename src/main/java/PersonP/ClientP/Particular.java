package PersonP.ClientP;

/**
 * Class for particular
 * @author Pedro Sala Mora
 * @version 1
 */
public class Particular extends Client{
    private String dni;

    //Builders
    public Particular(String name, String password, String location,
                      String email, int id_Client, String dni) {
        super(name, password, location, email, id_Client);
        this.dni = dni;
    }

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
