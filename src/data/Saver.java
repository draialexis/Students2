package data;

import viewmodel.PromotionVM;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Saver implements Savable {
    @Override
    public void save(PromotionVM VM) throws IOException {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("save.bin"))) {
            oos.writeObject(VM.getModel());
        }
    }
}
