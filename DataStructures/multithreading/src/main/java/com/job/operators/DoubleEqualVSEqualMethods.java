package com.job.operators;

public class DoubleEqualVSEqualMethods {

    public static void main(String[] args) {
        //primtives
        int a =10;
        int b =20;
        System.out.println(a==b);

        //Reference types
        String a1 =new String("Hello");
        String b1=new String("Hello");
        System.out.println(a1==b1); //false - different objects in memory
        System.out.println(a1.hashCode()+" : "+b1.hashCode());
        System.out.println(a1.equals(b1)); //true - same content

        Person p1 =new Person(24,"Rakesh");
        Person p2=new Person(24,"Rakesh");

        System.out.println(p1==p2);
        System.out.println(p1.hashCode()+" : "+p2.hashCode());
        System.out.println(p1.equals(p2));

    }
}
