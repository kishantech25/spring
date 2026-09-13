package com.mini.ioc;

import java.util.function.Consumer;

public class ConsumerDemos {


    static Consumer<String> printer =(s)->System.out.println(s);

    public static void main(String[] args) {

        printer.accept("Hello World");
        printer.accept("Welcome to java");
        printer.accept("welcome to AI World");

    }
}
