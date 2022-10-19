package data;

import model.Promotion;
import viewmodel.PromotionVM;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Loader implements Loadable {
    @Override
    public PromotionVM load() throws IOException, ClassNotFoundException {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("save.bin"))) {
            return new PromotionVM(ois.readObject());
        }
    }
}
