package lab2.test;

import lab2.model.AbstractForm;
import lab2.model.IWeight;
import lab2.model.Timber;
import lab2.model.Wood;
import lab2.store.ProductStore;
import lab2.store.WoodDirectory;

import java.util.Scanner;

public class TestByConsole {
    //Каталог для деревини;
    private WoodDirectory NewWd = new WoodDirectory();
    //Каталог для брусів
    private ProductStore Newps = new ProductStore();
    Scanner i = new Scanner(System.in);

    boolean TrueWork = true;

    public void startAppConsole(){
        System.out.println();
        System.out.println("Введіть 'd',щоб додати деревину, 'b', " +
                "щоб додати брус,'w',щоб вирахувати загальну вагу," +
                "'e', щоб завершити роботу програми");
        while (TrueWork)
        {
            System.out.println("");
            switch (i.nextLine())
            {
                case "d":
                    AddWood();
                    break;
                case "b":
                    AddTimber();
                    break;
                case "w":
                    calcWeight();
                    break;
                case "e":
                    EndProgram();
                    break;
                default:
                    System.out.println("!!!   Неправильно введені дані");
                    break;
            }
        }
    }

    private void EndProgram()
    {
        TrueWork=!TrueWork;
    }

    private void AddWood(){
        int id= NewWd.getArr().length;
        System.out.println("Можете ввести вид деревини");
        String name = i.nextLine();
        System.out.println("Можете ввести щільність деревини");
        float density=i.nextFloat();

        Wood newWood = new Wood(id,name,density);
        NewWd.add(newWood);
        System.out.println(NewWd);
    }

    private void AddTimber(){
        System.out.println(NewWd);
        System.out.println("Можете ввести id деревини");
        int id =i.nextInt();
        System.out.println("Можете ввести довжину бруска");
        float length = i.nextFloat();
        System.out.println("Можете ввести висоту бруска");
        float height = i.nextFloat();
        System.out.println("Можете ввести ширину бруска");
        float width=i.nextFloat();
        Newps.add(new Timber(NewWd.get(id),length,height,width));
        System.out.println("Список брусків"+Newps);
        id=-1;
    }

    private void calcWeight(){
        float fullWeight = 0;
        for (Object timber : Newps.getArr()){
            fullWeight+=((IWeight)timber).weight();
        }
        System.out.println(fullWeight);
    }
}