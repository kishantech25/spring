package com.job.primitves;

import java.math.BigInteger;

public class NarrowingConversion {

    //Larger numeric type
    public static void main(String[] args) {

        long l  =100;
        int x =(int)l;

        //another
        double d =10.99;
        int x1 =(int) d;
        System.out.println(x1);

        //Narrowing can loose the information

        int intX =130;
        byte byteB =(byte) intX;
        System.out.println(byteB);

        //overflow happens when the result exceeds the representation range
        int maxInt =Integer.MAX_VALUE;
        System.out.println(maxInt);

        maxInt++;
        System.out.println(maxInt);

        long maxLong =Long.MAX_VALUE;
        System.out.println(maxLong);
        maxLong++;
        System.out.println(maxLong);

        byte maxByte =Byte.MAX_VALUE;
        System.out.println(maxByte);

        maxByte++;
        System.out.println(maxByte);

        //Java Convieniently provide constants

        System.out.println(Byte.MIN_VALUE);
        System.out.println(Byte.MAX_VALUE);

        System.out.println(Short.MIN_VALUE);
        System.out.println(Short.MAX_VALUE);

        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);

        System.out.println(Long.MIN_VALUE);
        System.out.println(Long.MAX_VALUE);


    }
}
