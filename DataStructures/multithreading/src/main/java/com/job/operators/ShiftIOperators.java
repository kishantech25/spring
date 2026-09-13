package com.job.operators;

public class ShiftIOperators {

    public static void main(String[] args) {

        Object leftshifA=5;
        //left shift 1 digit
        Integer value1 =(Integer)leftshifA<<1;
        //left shift 2 digit
        Integer value2 =(Integer)leftshifA<<2;
        System.out.println(value1);//10
        System.out.println(value2);//20

        Object leftshifCharA='A';
        //left shift 1 digit
//        Object ch1=(Integer)(leftshifCharA<<1);
//        System.out.println((Character)ch1);

        long x=1;
        System.out.println(x<<62);
        int x1 =1_000_000_000;
        System.out.println(x1<<10);

        int negativeDigit=-1;
        System.out.println(negativeDigit<<2);


        //Right shift Operators
        int rightShiftX =8;
        System.out.println(rightShiftX >>1);//4
        System.out.println(rightShiftX >>2);//2
        System.out.println(rightShiftX >>3);//1
        //>>>
        int ShiftXOperators=-1;
        System.out.println(ShiftXOperators>>>1);


    }

}
