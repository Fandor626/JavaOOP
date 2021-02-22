package main;

import test.TestApp;
import test.TestByConsole;

public class main {
    public static void main(String[] args) {
        TestApp app=new TestApp();
        app.startApp();
        TestByConsole appConsole =new TestByConsole();
        appConsole.StartAppConsole();

    }
}
