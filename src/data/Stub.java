package data;

import viewmodel.PromotionVM;
import viewmodel.StudentVM;

public class Stub implements Loadable {

    @Override
    public PromotionVM load(){
        PromotionVM VM = new PromotionVM();

        VM.addStudentVM(new StudentVM("ONE", "Alan"));
        VM.addStudentVM(new StudentVM("TWO", "Allan"));
        VM.addStudentVM(new StudentVM("THREE", "Alllan"));
        VM.addStudentVM(new StudentVM("FOUR", "Allllan"));

        return VM;
    }
}
