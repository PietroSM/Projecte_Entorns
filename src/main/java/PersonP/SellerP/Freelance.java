package PersonP.SellerP;

public class Freelance extends Seller{
    public Freelance(String name, String password, String location, String email,
                     int id_Seller, String cif) {
        super(name, password, location, email, id_Seller, cif);
    }

    public Freelance() {
        this("","","","",0,"");
    }

    @Override
    public String toString() {
        return "Freelance{} " + super.toString();
    }
}
