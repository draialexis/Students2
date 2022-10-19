package data;

import javafx.scene.paint.Color;
import viewmodel.PromotionVM;
import viewmodel.StudentVM;

public class Stub implements Loadable {

    @Override
    public PromotionVM load(){
        PromotionVM VM = new PromotionVM();

        VM.addStudentVM(new StudentVM("ONE", "Alan", Color.BLACK));
        VM.addStudentVM(new StudentVM("TWO", "Allan", Color.AQUAMARINE));
        VM.addStudentVM(new StudentVM("THREE", "Alllan", Color.ORANGERED));
        VM.addStudentVM(new StudentVM("FOUR", "Allllan", Color.WHITESMOKE));

        return VM;
    }
}
