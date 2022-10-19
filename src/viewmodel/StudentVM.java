package viewmodel;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import model.Student;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class StudentVM implements PropertyChangeListener {
    private final Student model;

    public Student getModel() {
        return model;
    }

    private final StringProperty lastname = new SimpleStringProperty();
    public String getLastname() {return lastname.get();}
    public StringProperty lastnameProperty() {return lastname;}
    private void setLastname(String lastname) {this.lastname.set(lastname);}

    private final StringProperty firstname = new SimpleStringProperty();
    public String getFirstname() {return firstname.get();}
    public StringProperty firstnameProperty() {return firstname;}
    public void setFirstname(String firstname) {this.firstname.set(firstname);}

    public StudentVM(Object o) {
        Student model;
        if (o instanceof Student) {
            model = (Student) o;
        }
        else {
            model = new Student("", "");
        }

        this.model = model;

        // load into self
        setFirstname(model.getFirstname());
        setLastname(model.getLastname());

        // subscribe
        model.addListener(this);

        // promise to update
        firstnameProperty().addListener((__, ___, newV) -> model.setFirstname(newV));
    }

    public StudentVM(String lastname, String firstname) {
        this(new Student(lastname, firstname));
    }

    public StudentVM(Student model) {
        this((Object) model);
    }

    public StudentVM() {
        this(null);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(Student.PROP_STUDENT_FIRSTNAME)) {
            setFirstname((String) evt.getNewValue());
        }
    }
}
