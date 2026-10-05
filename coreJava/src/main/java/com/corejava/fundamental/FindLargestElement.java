package com.corejava.fundamental;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindLargestElement {

    //Without Stream Api
    public int findLargestElement(int[] arr){

        int max =Integer.MIN_VALUE;

//        if(arr==null || arr.length<2){
//            return throw new IllegalArgumentException("Array not applicable");
//        }

        for(int value:arr){
            if(value>max){
                max = value;
            }
        }
        return max;
    }
//WitStream API
    public void findLargestElement1(int [] arr){
        System.out.println(Arrays.stream(arr).max().orElse(-1));


    }


}
