package com.job;

public class StaticDemo {

    static int x =10;
    static String name;
    static double d;
    static int count;


    public static void main(String[] args) {

        StaticDemo demo = new StaticDemo();

        System.out.println(demo.x);

       System.out.println(demo.name);
       System.out.println(demo.d);

    }
}
