package PersonP.ClientP;

import PersonP.Person;
import ProductP.Product;
import java.util.ArrayList;

/**
 * Abstract class used as a template for client users
 * @author Pedro Sala Mora
 * @version 1
 */
public abstract class Client extends Person {
    protected int id_Client;


    /**
     * Constructor with parameters
     * @param name A String with the client name
     * @param password A String with the client password
     * @param location A String with the client location
     * @param email A String with the client email
     * @param id_Client An int with the client id_Client
     */
    public Client(String name, String password, String location, String email,
                  int id_Client) {
        super(name, password, location, email);
        this.id_Client = id_Client;
    }

    /**
     * Constructor without parameters
     */
    public Client() {
        this("","","","",0);
    }


    //Getters and Setters
    public int getId_Client() {
        return id_Client;
    }

    public void setId_Client(int id_Client) {
        this.id_Client = id_Client;
    }


    
    //Override methods
    @Override
    public String toString() {
        return "Client{" +
                "id_Client=" + id_Client +
                "} " + super.toString();
    }
}
