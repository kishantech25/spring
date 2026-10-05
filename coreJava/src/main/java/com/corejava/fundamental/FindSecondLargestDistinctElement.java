package com.corejava.fundamental;

import java.util.Arrays;

public class FindSecondLargestDistinctElement {

    public int secondLargestElement(int []arr){
        int max =Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

//        if(arr.length<2 || arr == null){
//            return throw new IllegalArgumentException("array not applicable");
//        }

       for(int value:arr){
           if(value>max){
               secondMax=max;
               max=value;
           }else if(value>secondMax && value<max){
               secondMax = value;
           }
       }
       System.out.println("Second Largest= "+secondMax);
       return  secondMax;
    }

//    public Long findSecondLargestElement(int[]arr){
//       return  Arrays.stream(arr).asLongStream().max().stream().skip(1);
//    }

}
