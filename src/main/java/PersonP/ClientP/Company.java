package PersonP.ClientP;


public class Company extends Client{
    private String cif;

    public Company(String name, String password, String location,
                   String email, int id_Client, String cif) {
        super(name, password, location, email, id_Client);
        this.cif = cif;
    }


    public Company() {
        this("","","","",0,"");
    }
}
