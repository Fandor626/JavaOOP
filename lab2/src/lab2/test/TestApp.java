package lab2.test;

import lab2.model.*;
import lab2.store.ProductStore;
import lab2.store.WoodDirectory;

public class TestApp {

    //Каталог для деревини;
    private WoodDirectory wd = new WoodDirectory();
    //Каталог для брусів
    private ProductStore ps = new ProductStore();

    public void startApp(){
        //Наповнюємо сховище брусів
        wd.add(new Wood(0, "Dub", 1.4f));
        wd.add(new Wood(1,"Sosna",2.5f));
        wd.add(new Wood(2,"Bereza",3f));
        ps.add(new Timber(wd.get(0),12f,0.6f,0.4f ));
        ps.add(new Timber(wd.get(1),15f,0.6f,0.4f ));
        ps.add(new Cylinder((wd.get(2)), 11f,22f));
        ps.add(new Waste(3.5f));
        //Друкуємо перелік продуктів
        System.out.println(wd);
        System.out.println(ps);
        //Обчислюємо вагу продуктів
        System.out.printf("Загальна вага: %1.3f", calcWeight());
    }

    private float calcWeight(){
        float fullWeight = 0;
        for (Object timber : ps.getArr()){
            fullWeight+= ((IWeight)timber).weight();
        }
        return fullWeight;
    }
}
