package com.corejava.fundamental.stream;

public class FIndMaximim {

    public int findTheLargestElement(int [] arr){

        int max=arr[0];
        if(arr ==null && arr.length<=1){
            throw new IllegalArgumentException("array length is too less ");
        }
        for(int i=0;i<arr.length;i++){

            if(arr[i]>max){
                max = arr[i];
            }
        }
        return max;

    }

}
