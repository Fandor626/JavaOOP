package lab7.threads;

import lab7.model.IWeight;
import lab7.store.ProductStore;
import lab7.store.WoodDirectory;

import java.util.Random;

    public abstract class WoodShop implements Runnable {
    WoodDirectory wd;
    ProductStore ps;
    Random rnd=new Random();
    int n;
    String name;

    public WoodShop(String name, WoodDirectory wd, ProductStore ps, int n){
        super();
        this.name=name;
        this.wd=wd;
        this.ps=ps;
        this.n=n;
    }
    protected abstract IWeight createProduct()throws Exception;
    public void run(){
        for (int i = 0; i < n; i++) {
            try {
                IWeight product = createProduct();
                ps.add(product);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
