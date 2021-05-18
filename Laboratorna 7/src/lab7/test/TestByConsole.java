package lab7.test;

import lab7.model.*;
import lab7.store.ProductStore;
import lab7.store.WoodDirectory;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.io.*;
import java.util.Date;
import java.util.Scanner;

public class TestByConsole implements Serializable {
    //Каталог для деревини;
    private WoodDirectory NewWd = new WoodDirectory();
    //Каталог для брусів
    private ProductStore Newps = new ProductStore();
    Scanner i = new Scanner(System.in);
    private BufferedWriter bw = new BufferedWriter(new FileWriter("Log.TXT",true));

    boolean TrueWork = true;

    public TestByConsole() throws IOException {
    }

    private void WriteString(String s){
        try {
            bw.write((new Date()) + " " + s);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void startAppConsole(){
        System.out.println();
        System.out.println("Введіть 'd',щоб додати деревину, 'b', " +
                "щоб додати брус,'w',щоб вирахувати загальну вагу," +
                "'e', щоб завершити роботу програми"+", 'c',щоб додати Циліндр, "+
                "'v',щоб додати відходи ");
        Name();
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
                case "c":
                    AddCylinder();
                    break;
                case "v":
                    AddWaste();
                    break;
                case "e":
                    EndProgram();
                    break;
                case "save":
                    SerializationSave();
                    DeSerializationLoad();
                    break;
                case "t":
                    ToTxt();
                    try {
                        bw.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    return;
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
        if (NewWd.add(newWood)) {
            WriteString(newWood.toString());
        } else {
            System.out.println(newWood + " id вже існує\n");
        }
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
        try {
            Timber t = new Timber(NewWd.get(id), length, height, width);
            Newps.add(t);
            WriteString(t.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Список брусків "+Newps);
        id=-1;
    }
    private void AddCylinder(){
        System.out.println(NewWd);
        System.out.println("Можете ввести id деревини");
        int id=i.nextInt();
        System.out.println("Можете ввести довжину циліндра");
        float length=i.nextFloat();
        System.out.println("Можете ввести діаметр циліндра");
        float diameter=i.nextFloat();
        try {
            Cylinder c = new Cylinder(NewWd.get(id), length, diameter);
            Newps.add(c);
            WriteString(c.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(Newps);
        id=-1;
    }
    private void AddWaste(){
        System.out.println("Можете ввести кількість відходів (кг)");
        float weight =i.nextFloat();
        try {
            Waste w = new Waste(weight);
            Newps.add(w);
            WriteString(w.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(Newps);
    }
    private void calcWeight(){
        float fullWeight = 0;
        for (Object timber : Newps.getArr()){
            fullWeight+=((IWeight)timber).weight();
        }
        System.out.println(fullWeight);
    }
    private void  DeSerializationLoad() {
        //Відновлення WoodDirecroty з файлу
        File f = new File("wd.object");
        try{
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            NewWd = (WoodDirectory) ois.readObject();
            ois.close();
        }catch(Exception e) {
            e.printStackTrace();
        }
        //Виведення WoodDirecroty на консоль
        if (NewWd != null){
            for (Object w: NewWd.getArr())
                System.out.println(w.toString());
        }
    }
    private void SerializationSave(){
        File f = new File("wd.object");
        try{
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(NewWd);
            oos.close();
        }catch (Exception e ){
            e.printStackTrace();
        }
        //Збереження ProductStore у файлі
        File ff = new File("ps.object");
        try{
            FileOutputStream fos1 = new FileOutputStream(ff);
            ObjectOutputStream oos1 = new ObjectOutputStream(fos1);
            oos1.writeObject(Newps);
            oos1.close();
        }catch (Exception e ) {
            e.printStackTrace();
        }
    }
    private void ToTxt(){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        JFileChooser dialog =new JFileChooser();
        dialog.setFileFilter(new FileFilter() {
            @Override
            public boolean accept(File f) {
                if(f!=null)
                {
                    //відображати усі папки та файли .txt
                    return f.isDirectory()||f.toString().endsWith(".txt");
                }
                return false;
            }
            @Override
            public String getDescription() {
                return "Файли типу *txt";
            }
        });
        dialog.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        dialog.setDialogTitle("Виберіть потрібні файли і папки");
        dialog.setApproveButtonText("Open");
        dialog.setMultiSelectionEnabled(true);
        dialog.showSaveDialog(null);
        File [] ff= dialog.getSelectedFiles();
        if(ff!=null) {
            for (File f : ff) {
                System.out.println(f.getAbsolutePath());
                //формування текстового файлу з каталогом деревини та виробів
                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter(f));
                    writer.write(NewWd.toString());
                    writer.newLine();
                    writer.write(Newps.toString());
                    writer.close();
                    System.out.println("Файл збережено");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
    private void Name(){
        System.out.println("Введіть ваше ім'я");
        String s = i.nextLine();
        try {
            bw.write((new Date())+" ");
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}