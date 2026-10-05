package com.corejava.fundamental.stream;

public class FindTheMissingNumber {

    public int findMissingNumber(int [] arr){
        //{3,0,1}
        int n =arr.length;

        int expectedNumber =n*(n+1)/2;

        int totalSum=0;

        for(int a:arr){
            totalSum+=a;
        }
        int missingNumber =expectedNumber -totalSum;

        System.out.println("Missing Number is: "+missingNumber);

        return missingNumber;
    }
}
