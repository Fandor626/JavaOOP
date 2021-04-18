package lab3.test;

import lab3.store.WoodDirectory;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.io.*;
import java.nio.Buffer;

public class TestFile {
    public static void main() {

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
        dialog.showOpenDialog(null);
        File f = dialog.getSelectedFile();
        if (f != null) {
            System.out.println(f.getName());
            System.out.println(f.getAbsolutePath());
        }
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(f));
            for (int i = 0; i < 10; i++) {
                double x = Math.random();
                String s = String.valueOf(x);
                writer.write(s);
                writer.newLine();
            }
            writer.write("Oleksyuk Bohdan КН-19");

            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        BufferedReader reader=null;
        if(f!=null) {
            try{
                reader = new BufferedReader(new FileReader(f));
                String s;
                while((s= reader.readLine())!=null)
                {
                    System.out.println(s);
                }
                reader.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}


