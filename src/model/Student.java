package model;

import utils.HairColor;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;

public class Student implements Serializable {

    public static final String PROP_STUDENT_FIRSTNAME = "model.Student.firstname";
    private static final String PROP_STUDENT_HAIR_COLOR = "model.Student.hairColor";

    private final String lastname;

    private String firstname;

    private HairColor hairColor;

    public Student(String lastname, String firstName, HairColor hairColor) {
        this.lastname = !lastname.isEmpty() ? lastname : "_";
        this.firstname = !firstName.isEmpty() ? firstName : "_";
        this.hairColor = hairColor != null ? hairColor : new HairColor(0.0, 0.0, 0.0);
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public HairColor getHairColor() {
        return hairColor;
    }

    public void setHairColor(HairColor hairColor) {
        if(hairColor != null) {
            HairColor oldV = getHairColor();
            this.hairColor = hairColor;
            // fire
            getSupport().firePropertyChange(PROP_STUDENT_HAIR_COLOR, oldV, getHairColor());
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
