package model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Promotion implements Serializable {
    public static final String PROP_PROMOTION_ADD_STUDENT = "model.Promotion.addStudent";
    public static final String PROP_PROMOTION_RMV_STUDENT = "model.Promotion.removeStudent";

    private final List<Student> students = new ArrayList<>();

    public List<Student> getStudents() {
        return Collections.unmodifiableList(students);
    }

    public void addStudent(Student toAdd) {
        if (toAdd != null) {
            int i = 0;

            students.add(i, toAdd);
            // fire
            getSupport().fireIndexedPropertyChange(
                    PROP_PROMOTION_ADD_STUDENT,
                    i,
                    students.size() > i + 1 ? students.get(i + 1) : null,
                    toAdd
            );
        }
    }

    public void removeStudent(Student toRemove) {
        if (toRemove != null) {
            int i = students.indexOf(toRemove);

            students.remove(i);
            // fire
            getSupport().fireIndexedPropertyChange(
                    PROP_PROMOTION_RMV_STUDENT,
                    i,
                    toRemove,
                    students.size() > i ? students.get(i) : null
            );
        }
    }

    PropertyChangeSupport support = null;

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
