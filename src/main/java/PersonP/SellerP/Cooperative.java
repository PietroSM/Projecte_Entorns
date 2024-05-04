package PersonP.SellerP;

public class Cooperative extends Seller{
    public Cooperative(String name, String password, String location, String email,
                       int id_Seller, String cif) {
        super(name, password, location, email, id_Seller, cif);
    }

    public Cooperative() {
        this("","","","",0,"");
    }

    @Override
    public String toString() {
        return "Cooperative{} " + super.toString();
    }
}
