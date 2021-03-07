package com.company;

import lab3.test.TestApp;
import lab3.test.TestByConsole;
import lab3.test.TestFile;

public class Main {

    public static void main(String[] args) {
        TestApp app = new TestApp();
        app.startApp();

        TestByConsole appConsole= new TestByConsole();
        appConsole.startAppConsole();

        TestFile file=new TestFile();
        file.main();
    }
}
