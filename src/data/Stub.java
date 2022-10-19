package data;

import viewmodel.PromotionVM;

public class Stub implements Loadable {

    @Override
    public PromotionVM load(){
        PromotionVM VM = new PromotionVM();

        //... add studentVMs

        return VM;
    }
}
