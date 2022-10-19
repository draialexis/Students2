package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

public class Student implements Serializable {

    public static final String PROP_STUDENT_LASTNAME = "model.Student.lastname";
    public static final String PROP_STUDENT_FIRSTNAME = "model.Student.firstname";

    private String lastname;

    private String firstname;

    public Student(String lastname, String firstName) {
        this.lastname = !lastname.isEmpty() ? lastname : "DOE";
        this.firstname = !firstName.isEmpty() ? firstName : "John";
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setLastname(String lastname) {
        if(lastname != null) {
            String oldV = getLastname();
            this.lastname = lastname;
            // fire
            getSupport().firePropertyChange(PROP_STUDENT_LASTNAME, oldV, getLastname());
        }
    }

    public void setFirstname(String firstname) {
        if(firstname != null) {
            String oldV = getFirstname();
            this.firstname = firstname;
            // fire
            getSupport().firePropertyChange(PROP_STUDENT_FIRSTNAME, oldV, getFirstname());
        }
    }

    private PropertyChangeSupport support = null;

    public PropertyChangeSupport getSupport() {
        if (support == null) {
            support = new PropertyChangeSupport(this);
        }
        return support;
    }

    public void addListener(PropertyChangeListener listener) {
        getSupport().addPropertyChangeListener(listener);
    }
}
