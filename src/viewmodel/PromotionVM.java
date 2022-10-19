package viewmodel;

import javafx.beans.property.ListProperty;
import javafx.beans.property.ReadOnlyListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Promotion;

import java.beans.IndexedPropertyChangeEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class PromotionVM implements PropertyChangeListener {

    private final Promotion model;

    public Promotion getModel() {
        return model;
    }

    public PromotionVM(Object o) {
        Promotion model;
        if (o instanceof Promotion) {
            model = (Promotion) o;
        }
        else {
            model = new Promotion();
        }
        this.model = model;

        // load
        model.getStudents().forEach(s -> studentsVMObs.add(new StudentVM(s)));

        // subscribe
        model.addListener(this);

        // promise to update
        // ... in methods
    }

    public PromotionVM() {
        this(null);
    }

    public void addStudentVM(StudentVM toAdd) {
        model.addStudent(toAdd.getModel());
    }

    public void removeStudentVM(StudentVM toRemove) {
        model.removeStudent(toRemove.getModel());
    }

    private final ObservableList<StudentVM> studentsVMObs = FXCollections.observableArrayList();
    private final ListProperty<StudentVM> studentsVM = new SimpleListProperty<>(studentsVMObs);
    public ObservableList<StudentVM> getStudentsVM() {return FXCollections.unmodifiableObservableList(studentsVM.get());}
    public ReadOnlyListProperty<StudentVM> studentsVMProperty() {return studentsVM;}

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals(Promotion.PROP_PROMOTION_ADD_STUDENT)) {
            studentsVMObs.add(((IndexedPropertyChangeEvent) evt).getIndex(), new StudentVM(evt.getNewValue()));
        }
        if (evt.getPropertyName().equals(Promotion.PROP_PROMOTION_RMV_STUDENT)) {
            studentsVMObs.remove(((IndexedPropertyChangeEvent) evt).getIndex());
        }
    }
}
