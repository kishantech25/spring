package com.example;

public class CollectionDemo {

    public static void main(String[] args) {


        //to resolve to store any type of object Array
        Object[] o =new Object[1000];
        o[1]= new Student();
        o[2] =new Object();

      System.out.println(o[1]+"::"+o[2]);

    }


}
