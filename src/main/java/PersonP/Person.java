package PersonP;

import java.util.Objects;

/**
 * Abstract class that serves as a template for user types
 * @author Pedro Sala Mora
 * @version 1
 */
public abstract class Person {
    protected String name;
    protected String password;
    protected String location;
    protected String email;


    /**Builders*/
    public Person() {
        this("","","","");
    }

    public Person(String name, String password, String location, String email) {
        this.name = name;
        this.password = password;
        this.location = location;
        this.email = email;
    }


    /**Getters and Setters*/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    /**Override Methods*/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        return Objects.equals(email, person.email);
    }

    @Override
    public int hashCode() {
        return email != null ? email.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", location='" + location + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
