package com.job.methods;

public class Printter {

    void print(long x){
        System.out.println("long");
    }
    void print(double x){
        System.out.println("double");
    }

    public static void main(String[] args) {

        Printter printter = new Printter();
        printter.print(10);
        printter.print(10.5);
    }

}
