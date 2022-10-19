package viewmodel;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.paint.Color;
import model.Student;
import utils.ColorConverter;

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

    private final ObjectProperty<Color> hairColor = new SimpleObjectProperty<>();
    public Color getHairColor() {return hairColor.get();}
    public ObjectProperty<Color> hairColorProperty() {return hairColor;}
    public void setHairColor(Color hairColor) {this.hairColor.set(hairColor);}

    public StudentVM(Object o) {
        Student model;
        if (o instanceof Student) {
            model = (Student) o;
        }
        else {
            model = new Student("", "", null);
        }

        this.model = model;

        // load into self
        setFirstname(model.getFirstname());
        setLastname(model.getLastname());
        setHairColor(ColorConverter.toJFXColor(model.getHairColor()));

        // subscribe
        model.addListener(this);

        // promise to update
        firstnameProperty().addListener((__, ___, newV) -> model.setFirstname(newV));
        hairColorProperty().addListener((__, ___, newV) -> model.setHairColor(ColorConverter.toHairColor(newV)));
    }

    public StudentVM(String lastname, String firstname, Color JFXHairColor) {
        this(new Student(lastname, firstname, ColorConverter.toHairColor(JFXHairColor)));
    }

    public StudentVM(Student model) {
        this((Object) model);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(Student.PROP_STUDENT_FIRSTNAME)) {
            setFirstname((String) evt.getNewValue());
        }
        if (evt.getPropertyName().equals(Student.PROP_STUDENT_FIRSTNAME)) {
            setHairColor(ColorConverter.toJFXColor(evt.getNewValue()));
        }
    }
}
