package com.job.operators;

public class WrapperTrap {

    public static void main(String[] args) {

        Integer a =1;
        //same
        //Integer.valueof(1)
        Integer b =1;
        //Integer.valueof(1)




        System.out.println(a.intValue()==b.intValue());
        Integer c=1000;
        Integer d=1000;
        System.out.println(c.intValue()==d.intValue());
    }
}
