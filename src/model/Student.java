package model;

import java.io.Serializable;

public class Student implements Serializable {

    private final String lastname;

    private String firstName;

    public Student(String lastname, String firstName) {
        this.lastname = lastname;
        this.firstName = firstName;
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
}
