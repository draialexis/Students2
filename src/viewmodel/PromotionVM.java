package viewmodel;

import model.Promotion;

public class PromotionVM {

    private Promotion model;

    public PromotionVM(Object o) {

    }

    public PromotionVM() {

    }

    public Promotion getModel() {
        return model;
    }

    public void addStudent(StudentVM toAdd) {
    }

    public void addStudent() { addStudent(new StudentVM()); }

    public void removeStudent(StudentVM toRemove) {
    }
}
