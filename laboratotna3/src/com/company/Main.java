package com.company;

import lab3.test.*;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        TestByConsole appConsole = new TestByConsole();
        appConsole.startAppConsole();

        TestFile File=new TestFile();
        File.main();
    }
}
