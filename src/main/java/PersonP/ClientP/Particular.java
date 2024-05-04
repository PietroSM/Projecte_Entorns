package PersonP.ClientP;

public class Particular extends Client{
    private String dni;

    public Particular(String name, String password, String location,
                      String email, int id_Client, String dni) {
        super(name, password, location, email, id_Client);
        this.dni = dni;
    }

    public Particular() {
        this("","","","",0,"");
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Particular{" +
                "dni='" + dni + '\'' +
                "} " + super.toString();
    }
}
