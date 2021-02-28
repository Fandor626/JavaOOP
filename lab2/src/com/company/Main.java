package com.company;

import lab2.test.TestApp;
import lab2.test.TestByConsole;

public class Main {

    public static void main(String[] args) {
        TestApp app = new TestApp();
        app.startApp();

        TestByConsole appConsole= new TestByConsole();
        appConsole.startAppConsole();
    }
}
