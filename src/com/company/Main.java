package com.company;

import lab6.test.*;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
      /*  TestApp testApp=new TestApp();
        testApp.startApp();

        TestByConsole appConsole = new TestByConsole();
        appConsole.startAppConsole();*/

        TestCollections testCollections=new TestCollections();
        testCollections.main();
    }
}
