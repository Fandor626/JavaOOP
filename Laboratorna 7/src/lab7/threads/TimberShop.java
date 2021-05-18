package lab7.threads;

import lab7.model.IWeight;
import lab7.store.ProductStore;
import lab7.store.WoodDirectory;
import lab7.model.*;

import javax.naming.Name;
import java.util.Random;

public class TimberShop extends WoodShop{

    WoodDirectory wd;
    ProductStore ps;
    Random rnd=new Random();
    int n;
    String name;

    public String getName(){
    return name;
    }

    public TimberShop(String name, WoodDirectory wd, ProductStore ps, int n) {
        super(name,wd,ps,n);
    }

    public IWeight createProduct() throws Exception {
        int woodId=rnd.nextInt(3);
        Wood wood=wd.get(woodId);
        float length=1+rnd.nextFloat();
        float height= 0.1f+rnd.nextFloat();
        float width= 0.1f+rnd.nextFloat();

        Timber timber=new Timber(wood,length,height,width);
        return timber;
    }
    int fibo(int n){
        if(n<2)
            return 1;
        return fibo(n-1)+fibo(n-2);
    }
    public void run(){
        for (int i = 0; i < n; i++) {
            fibo(40+rnd.nextInt(5));
            IWeight timber = null;
            try {
                timber = createProduct();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(this.getName()+" create "+timber);
        }
    }
}
