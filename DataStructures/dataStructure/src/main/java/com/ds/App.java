package com.ds;

import com.ds.record.Employee;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        int[] intArray =new int[7];
//         intArray[0] =20;
//         intArray[1]=30;
//         intArray[2]=-15;
//         intArray[3]=7;
//         intArray[4]=55;
//         intArray[5]=1;
//         intArray[6]=-22;
//
//       System.out.println(Arrays.toString(intArray));

        Class<?> c =Employee.class;
        System.out.println(c.isRecord());

    }
}
