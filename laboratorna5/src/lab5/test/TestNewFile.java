package lab5.test;

import javax.swing.*;
import java.io.File;

public class TestNewFile {
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
        JFileChooser dialog = new JFileChooser();
        dialog.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        dialog.setDialogTitle("Oleksyuk Bohdan KH-19");
        dialog.setApproveButtonText("Відкрити");
        dialog.setMultiSelectionEnabled(true);
        dialog.showOpenDialog(null);
        File[] ff = dialog.getSelectedFiles();
        if (ff != null) {
            for (File f : ff) {
                System.out.println(f.getAbsolutePath());
            }
        }
    }
}
