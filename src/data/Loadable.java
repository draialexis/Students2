package data;

import viewmodel.PromotionVM;

import java.io.IOException;

public interface Loadable {
    PromotionVM load() throws IOException, ClassNotFoundException;
}
