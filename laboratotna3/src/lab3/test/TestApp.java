package lab3.test;

import lab3.model.*;
import lab3.store.ProductStore;
import lab3.store.WoodDirectory;

import javax.swing.*;

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
        try {
            ps.add(new Timber(wd.get(0),12f,0.6f,0.4f ));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage(),
                    " Введення продуктів", JOptionPane.ERROR_MESSAGE);
        }
        try {
            ps.add(new Cylinder((wd.get(2)), 11f,22f));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage(),
                    " Введення продуктів", JOptionPane.ERROR_MESSAGE);
        }
        try {
            ps.add(new Waste(0.025f));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage(),
                    " Введення продуктів", JOptionPane.ERROR_MESSAGE);
        }
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
