package lab4.test;

import lab4.store.*;

import java.io.*;

public class TestRestoreObject {
    public static void main() {
        WoodDirectory wd=null;
        File f=new File("Test.object");
        try {
            FileInputStream fis=new FileInputStream(f);
            ObjectInputStream ois=new ObjectInputStream(fis);
            wd=(WoodDirectory) ois.readObject();
            ois.close();

        }catch (Exception e){
            e.printStackTrace();
        }
        if(wd!=null)
        {
            for(Object w:wd.getArr())
            {
                System.out.println(w.toString());
            }
        }
    }
}
