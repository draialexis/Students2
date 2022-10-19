package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Promotion implements Serializable {
    private final List<Student> students = new ArrayList<>();

    public List<Student> getStudents() {
        return Collections.unmodifiableList(students);
    }
}
