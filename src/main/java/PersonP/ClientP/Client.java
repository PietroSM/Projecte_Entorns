package PersonP.ClientP;

import PersonP.Person;
import ProductP.Product;

import java.util.ArrayList;

public abstract class Client extends Person {
    protected int id_Client;
    protected ArrayList<Product> list_cart;


    public Client(String name, String password, String location, String email,
                  int id_Client) {
        super(name, password, location, email);
        this.id_Client = id_Client;
        list_cart = new ArrayList<>();
    }

    public Client() {
        this("","","","",0);
    }

    public int getId_Client() {
        return id_Client;
    }

    public void setId_Client(int id_Client) {
        this.id_Client = id_Client;
    }

    //AddProduct

    //RemoveProduct

    //CalculatePrice

    //ShowProduct

    //ShowProductLocation

    //ShowProductCategory

    //Prucharse



    @Override
    public String toString() {
        return "Client{" +
                "id_Client=" + id_Client +
                "} " + super.toString();
    }
}
