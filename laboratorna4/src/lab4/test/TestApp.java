package lab4.test;

import lab4.model.*;
import lab4.store.*;
import lab4.store.ProductStore;
import lab4.store.WoodDirectory;

import javax.swing.*;
import java.util.Iterator;

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
        System.out.println();
        System.out.println("Перелік виробів до вилучення");
        System.out.println(ps.toString());
        Iterator<Object> itr= ps.iterator();
        while(itr.hasNext()){
            IWeight obj=(IWeight) itr.next();
            if (obj.weight()>1.2) itr.remove();
        }
        System.out.println("Перелік виробів після вилучення");
        System.out.println(ps.toString());
    }

    private float calcWeight(){
        float fullWeight = 0;
        for (Object timber : ps.getArr()){
            fullWeight+= ((IWeight)timber).weight();
        }
        return fullWeight;
    }
}
