package lab7.test;

import lab7.model.*;
import lab7.store.*;
import lab7.store.WoodDirectory;
import lab7.threads.CylinderShop;
import lab7.threads.TimberShop;
import lab7.threads.WoodShop;

import javax.swing.*;
import java.util.function.Predicate;

public class TestApp {

    //Каталог для деревини;
    private WoodDirectory wd = new WoodDirectory();
    //Каталог для брусів
    private ProductStore ps = new ProductStore();

    public void startApp() {
      /* wd.add(new Wood(0, "Dub", 1.4f));
        wd.add(new Wood(1, "Sosna", 2.5f));
        wd.add(new Wood(2, "Bereza", 3f));*/
      /*  Thread tshop1 = new TimberShop(wd, ps, 3);
        Thread tshop2 = new TimberShop(wd, ps, 3);
        Thread tshop3 = new TimberShop(wd, ps, 3);
        tshop1.start();
        tshop2.start();
        tshop3.start()*/
        WoodShop timbershop =new TimberShop("timbershop",wd,ps,5);
        WoodShop cylinderShop =new CylinderShop("timbershop",wd,ps,5);
        Thread tshop1 = new Thread(timbershop);
        Thread tshop2 = new Thread(cylinderShop);
        tshop1.start();
        tshop2.start();
        (new Thread(() -> {
            try {
                tshop1.join();
                tshop2.join();
                System.out.println(ps.getCount());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        })).start();

    }
}
