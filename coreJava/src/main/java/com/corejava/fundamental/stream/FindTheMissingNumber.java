package com.corejava.fundamental.stream;

import java.util.HashMap;
import java.util.Map;

public class FindTheMissingNumber {

      Map<Integer> map = new HashMap();

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
