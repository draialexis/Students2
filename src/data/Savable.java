package data;

import viewmodel.PromotionVM;

import java.io.IOException;

public interface Savable {
    void save(PromotionVM VM) throws IOException;
}
