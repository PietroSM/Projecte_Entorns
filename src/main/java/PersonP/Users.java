package PersonP;

import PersonP.ClientP.Company;

import java.util.ArrayList;

public class Users {
    private ArrayList<Person> list_Person;

    public Users() {
        list_Person = new ArrayList<>();
    }

    //ReadFile

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
}
