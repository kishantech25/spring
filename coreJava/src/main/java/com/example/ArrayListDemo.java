package com.example;

import java.util.ArrayList;

public class ArrayListDemo {

    public static void main(String[] args) {

        ArrayList l =new ArrayList();
        l.add("Pawan");
        l.add(100);
        l.add(10.5);
        l.add(null);
        l.add(new Object());

        System.out.println(l);
        l.remove(null);
        l.add("M");
        System.out.println(l);

    }
}
