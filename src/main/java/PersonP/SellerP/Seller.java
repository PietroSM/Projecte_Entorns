package PersonP.SellerP;

import PersonP.Person;

public abstract class Seller extends Person {
    protected int id_Seller;
    protected String cif;

    public Seller(String name, String password, String location, String email,
                  int id_Seller, String cif) {
        super(name, password, location, email);
        this.id_Seller = id_Seller;
        this.cif = cif;
    }

    public Seller() {
        this("","","","",0,"");
    }

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

    @Override
    public String toString() {
        return "Seller{" +
                "id_Seller=" + id_Seller +
                ", cif='" + cif + '\'' +
                "} " + super.toString();
    }
}
