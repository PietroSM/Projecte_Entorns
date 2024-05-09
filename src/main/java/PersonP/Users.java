package PersonP;

import PersonP.ClientP.Client;
import PersonP.ClientP.Company;
import PersonP.ClientP.Particular;
import PersonP.SellerP.Cooperative;
import PersonP.SellerP.Freelance;
import PersonP.SellerP.Seller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Users {


    private ArrayList<Person> list_Person;


    public Users() {
        list_Person = new ArrayList<>();
    }

    public ArrayList<Person> getList_Person() {
        return list_Person;
    }

    //ReadFile
    public void ReadFile(){
        String line = "";

        try{
            BufferedReader myFile = new BufferedReader(
                    new FileReader(
                            "I:\\Entorns_Desenvolupament\\Projecte_Final" +
                                    "\\Projecte_ED_v2\\src\\File\\Users.txt"));
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



    //SaveFile

    //AddUser
    public void AddUser(Person person){
        list_Person.add(person);
    }

    //Debugger
    public String Showone(int pos){
        return list_Person.get(pos).toString();
    }

    //RemoveUser

    //CheckUserExist

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


    //Return User;
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
