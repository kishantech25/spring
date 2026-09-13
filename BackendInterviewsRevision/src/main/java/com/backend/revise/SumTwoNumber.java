package com.backend.revise;

import java.util.HashMap;
import java.util.Map;

public class SumTwoNumber {



//    Two Sum Problem:
//    Question: Given an array of integers, find two numbers such that they add up to a specific target number. Use a hashmap to achieve an efficient solution.
//    Input: An array of integers and a target sum.
//    Output: Indices of the two numbers that add up to the target sum.

    public static  int sum(int [] array,int target){

        Map<Integer, Integer> map = new HashMap<>();

        for(int i:array){
             //check the target value in array
            if(!map.containsKey(i)){
                map.put(i,map.getOrDefault(i,0)+1);
            }
        }



    }

}
