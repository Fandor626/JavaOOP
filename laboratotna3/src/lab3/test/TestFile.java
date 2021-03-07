package lab3.test;

import javax.swing.*;
import java.io.File;

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
        dialog.showOpenDialog(null);
        File f=dialog.getSelectedFile();
        if (f!=null){
            System.out.println(f.getName());
            System.out.println(f.getName());
        }
        dialog.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        dialog.setDialogTitle("Виберіть потрібні файли і папки");
        dialog.setApproveButtonText("Open");
        dialog.setMultiSelectionEnabled(true);
        dialog.showSaveDialog(null);
        File ff=dialog.getSelectedFile();
        if(ff!=null){
            for(File f: ff) {
                System.out.println(f.getAbsolutePath());
            }
        }
    }
}
