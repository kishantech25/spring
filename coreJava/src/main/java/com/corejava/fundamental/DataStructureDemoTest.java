package com.corejava.fundamental;

import com.corejava.fundamental.stream.FIndMaximim;
import com.corejava.fundamental.stream.FIndTheSecondLargestNumber;
import com.corejava.fundamental.stream.FindTheMissingNumber;

public class DataStructureDemoTest {

    public static void main(String[] args) {

        int[] arr= {10,20,20,30,40,64,62,62,34,10};

        FIndMaximim maximum =new FIndMaximim();
        System.out.println(maximum.findTheLargestElement(arr));

        FIndTheSecondLargestNumber element =new FIndTheSecondLargestNumber();
        System.out.println(element.findSecondLargestElement(arr));

         int a[] ={3,0,1};

        FindTheMissingNumber number =new FindTheMissingNumber();
        number.findMissingNumber(a);




    }
}
