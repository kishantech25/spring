package com.corejava.fundamental.stream;

public class FIndTheSecondLargestNumber {

    public int findSecondLargestElement(int []arr){
        int max=Integer.MIN_VALUE;
        int secondMax =Integer.MIN_VALUE;

        for(int value:arr){

            if(value>max){
                secondMax=max;
                max=value;
            }else if(value<max && value>secondMax){
                secondMax=value;
            }

        }
        System.out.println("Second Largest = "+secondMax);

        if(arr==null && arr.length<=2){
            throw new IllegalArgumentException("Array is too small");
        }
        return secondMax;
    }
}
