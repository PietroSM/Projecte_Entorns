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
                            "D:\\Entorns_Desenvolupament\\Projecte_Final" +
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

    //CheckCredentials
    public boolean CheckCredentials(String email, String password){
        boolean result = false;

        if(list_Person.contains(new Cooperative("","","",email,0,""))){
            if(list_Person.get(list_Person.indexOf(
                    new Cooperative("","","",email,0,""))).
                    getPassword().equals(password)){
                result = true;
            }
        }
        return result;
    }

    //TypeOfUser
    public String TypeOfUser(String email){
        return list_Person.get(list_Person.indexOf(
                new Cooperative("","","",email,0,""))) instanceof Seller?"Seller":
                list_Person.get(list_Person.indexOf(
                        new Cooperative("","","",email,0,""))) instanceof Client?
                        "Client": "Error";
    }


    //PosInList
    public int PositionList(String email){
        return list_Person.indexOf(
                new Cooperative("","","",email,0,""));
    }


    //Return User;
    public Person PersonSearch(String email){
        return list_Person.get(list_Person.indexOf(
                new Cooperative("","","",email,0,"")));
    }
}
