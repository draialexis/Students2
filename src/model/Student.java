package model;

import java.io.Serializable;

public class Student implements Serializable {

    private String lastname;

    private String firstName;

    public Student(String lastname, String firstName) {
        this.lastname = !lastname.isEmpty() ? lastname : "DOE";
        this.firstName = !firstName.isEmpty() ? firstName : "John";
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
