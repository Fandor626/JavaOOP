package lab7.threads;

import lab7.model.Cylinder;
import lab7.model.IWeight;
import lab7.model.Wood;
import lab7.store.ProductStore;
import lab7.store.WoodDirectory;

public class CylinderShop extends WoodShop {

    public CylinderShop(String name, WoodDirectory wd, ProductStore ps, int n) {
        super(name, wd, ps, n);
    }

    @Override
    protected IWeight createProduct() throws Exception {
        int id = rnd.nextInt(3) + 1;
        Wood wood = wd.get(id);
        float length = 1 + rnd.nextFloat() * 5;
        float diameter = 0.1f + rnd.nextFloat();

        Cylinder cylinder = new Cylinder(wood, length, diameter);
        return cylinder;
    }
}