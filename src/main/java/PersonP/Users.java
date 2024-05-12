package PersonP;
import PersonP.ClientP.Client;
import PersonP.ClientP.Company;
import PersonP.ClientP.Particular;
import PersonP.SellerP.Cooperative;
import PersonP.SellerP.Freelance;
import PersonP.SellerP.Seller;

import java.io.*;
import java.util.ArrayList;

/**
 * Class in charge of managing the list of users
 * @author Pedro Sala Mora
 * @version 1
 */
public class Users {
    private final static String URL_FILE = "I:\\Entorns_Desenvolupament\\Projecte_Final" +
            "\\Projecte_ED_v2\\src\\File\\Users.txt";


    private ArrayList<Person> list_Person;


    //Builder
    public Users() {
        list_Person = new ArrayList<>();
    }


    //Getters and Setters
    public ArrayList<Person> getList_Person() {
        return list_Person;
    }


    /**
     * Method to read a file and load it into the list
     * (Metode per a llegir un fitxer i carregar-lo en la llista)
     */
    public void ReadFile(){
        String line = "";

        try{
            BufferedReader myFile = new BufferedReader(
                    new FileReader(URL_FILE));
            line = myFile.readLine();

            while(line!=null){
                String[] parts = line.split(";");

                //Cooperative
                if(parts[4].equals("3")){
                    list_Person.add(new Cooperative(parts[0],
                            parts[1], parts[2], parts[3],
                            Integer.parseInt(parts[4]), parts[5]));
                    //FreeLance
                }else if(parts[4].equals("2")){
                    list_Person.add(new Freelance(parts[0],
                            parts[1], parts[2], parts[3],
                            Integer.parseInt(parts[4]), parts[5]));
                    //Particular
                }else if(parts[4].equals("0")){
                    list_Person.add(new Particular(parts[0],
                            parts[1], parts[2], parts[3],
                            Integer.parseInt(parts[4]), parts[5]));
                    //Empresa
                }else if(parts[4].equals("1")){
                    list_Person.add(new Company(parts[0],
                            parts[1], parts[2], parts[3],
                            Integer.parseInt(parts[4]), parts[5]));
                }
                line = myFile.readLine();
            }
            myFile.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Method to save the created users in a .txt file and clear the list_Person
     * (Metode per a guardar els usuaris creats en un fitxer .txt i netejar la list_Person)
     */
    public  void SaveFile(){

        try{
            BufferedWriter myFile = new BufferedWriter(
                    new FileWriter(URL_FILE));

            for (int i = 0; i < list_Person.size(); i++) {
                if(list_Person.get(i) instanceof Particular){
                    myFile.write(list_Person.get(i).getName()+";"+
                            list_Person.get(i).getPassword()+";"+
                            list_Person.get(i).location+";"+
                            list_Person.get(i).getEmail()+";"+"0"+";"+
                            ((Particular) list_Person.get(i)).getDni()+"\n");
                } else if (list_Person.get(i) instanceof Company) {
                    myFile.write(list_Person.get(i).getName()+";"+
                            list_Person.get(i).getPassword()+";"+
                            list_Person.get(i).location+";"+
                            list_Person.get(i).getEmail()+";"+"1"+";"+
                            ((Company) list_Person.get(i)).getCif()+"\n");
                } else if (list_Person.get(i) instanceof Freelance) {
                    myFile.write(list_Person.get(i).getName()+";"+
                            list_Person.get(i).getPassword()+";"+
                            list_Person.get(i).location+";"+
                            list_Person.get(i).getEmail()+";"+"2"+";"+
                            ((Freelance) list_Person.get(i)).getCif()+"\n");
                } else if (list_Person.get(i) instanceof Cooperative) {
                    myFile.write(list_Person.get(i).getName()+";"+
                            list_Person.get(i).getPassword()+";"+
                            list_Person.get(i).location+";"+
                            list_Person.get(i).getEmail()+";"+"3"+";"+
                            ((Cooperative) list_Person.get(i)).getCif()+"\n");
                }
            }
            myFile.close();
        } catch (IOException e) {
            System.out.println("No se ha podido escribir en el fichero");
        }
    }

    /**
     * Method to add a person to the list
     * (Metode per afegir una persona en la llista)
     * @param person object we want to add
     */
    public void AddUser(Person person){
        list_Person.add(person);
    }

    /**
     * This method checks the user's credentials
     * (Aquest métode, comprova les creedencials del usuari)
     * @param email email entered by the user
     * @param password password entered by the user
     * @return a boolean telling if the credentials are true or false
     */
    public boolean CheckCredentials(String email, String password){
        boolean result = false;
        //Cooperative
        if(list_Person.contains(new Cooperative("","","",email,0,""))) {
            if (list_Person.get(list_Person.indexOf(
                            new Cooperative("", "", "", email, 0, ""))).
                    getPassword().equals(password)) {
                result = true;
            }
        }
        //Freelance
        if(list_Person.contains(new Freelance("","","",email,0,""))) {
            if (list_Person.get(list_Person.indexOf(
                            new Freelance("", "", "", email, 0, ""))).
                    getPassword().equals(password)) {
                result = true;
            }
        }
        //Particular
        if(list_Person.contains(new Particular("","","",email,0,""))) {
            if (list_Person.get(list_Person.indexOf(
                            new Particular("", "", "", email, 0, ""))).
                    getPassword().equals(password)) {
                result = true;
            }
        }
        //Company
        if(list_Person.contains(new Company("","","",email,0,""))) {
            if (list_Person.get(list_Person.indexOf(
                            new Company("", "", "", email, 0, ""))).
                    getPassword().equals(password)) {
                result = true;
            }
        }
        return result;
    }

    /**
     * This method checks what type the user who wants to log in is
     * (Aquest métode comprova de que tipo es el usuari que vol iniciar sessió)
     * @param email email entered by the user
     * @return the type of user
     */
    public String TypeOfUser(String email){
        String result = "Error";
        //Cooperative
        if(list_Person.contains(new Cooperative("","","",email,0,""))) {
            result = "Seller";
        }
        //Freelance
        if(list_Person.contains(new Freelance("","","",email,0,""))) {
            result = "Seller";
        }
        //Particular
        if(list_Person.contains(new Particular("","","",email,0,""))) {
            result = "Client";
        }
        //Company
        if(list_Person.contains(new Company("","","",email,0,""))) {
            result = "Client";
        }
        return result;
    }

    /**
     * This method finds the position in the list where the user is
     * (Aquest mètode busca la posició de la llista on es trova el ususari)
     * @param email email entered by the user
     * @return the position in the list
     */
    public int PositionList(String email){
        int result = 0;
        //Cooperative
        if(list_Person.contains(new Cooperative("","","",email,0,""))) {
            result = list_Person.indexOf(
                    new Cooperative("","","",email,0,""));
        }
        //Freelance
        if(list_Person.contains(new Freelance("","","",email,0,""))) {
            result = list_Person.indexOf(
                    new Freelance("","","",email,0,""));
        }
        //Particular
        if(list_Person.contains(new Particular("","","",email,0,""))) {
            result = list_Person.indexOf(
                    new Particular("","","",email,0,""));
        }
        //Company
        if(list_Person.contains(new Company("","","",email,0,""))) {
            result = list_Person.indexOf(
                    new Company("","","",email,0,""));
        }
        return result;
    }

    /**
     * method to search for a user and return it
     * (metode per a buscar un usuari i retornar-lo)
     * @param email user email
     * @return the person object
     */
    public Person PersonSearch(String email){
        Person p = null;
        //Cooperative
        if(list_Person.contains(new Cooperative("","","",email,0,""))) {
            p = list_Person.get(list_Person.indexOf(
                    new Cooperative("","","",email,0,"")));
        }
        //Freelance
        if(list_Person.contains(new Freelance("","","",email,0,""))) {
            p = list_Person.get(list_Person.indexOf(
                    new Freelance("","","",email,0,"")));
        }
        //Particular
        if(list_Person.contains(new Particular("","","",email,0,""))) {
            p = list_Person.get(list_Person.indexOf(
                    new Particular("","","",email,0,"")));
        }
        //Company
        if(list_Person.contains(new Company("","","",email,0,""))) {
            p = list_Person.get(list_Person.indexOf(
                    new Company("","","",email,0,"")));
        }
        return p;
    }

}
