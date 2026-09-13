package com.backend.revise;

public class BInarySearch {

//    Searching:
//    Question: Implement a binary search algorithm for a sorted array of integers and provide its complexity analysis.
//    Input: A sorted array of integers and a target integer.
//            Output: Index of the target integer or -1 if not found.
//    Time Complexity: O(log n), where n is the number of elements in the array.
//    Space Complexity: O(1) for iterative implementation.

     //10,20,30,40,50,60,70,               //50
    public void binarySearch(int[] array,int key){
        int low =array[0];
        int high=array[array.length-1];

        while(low<high){

            int mid=(low+high)/2;
            if(array[mid]>high){
                high=mid-1;
            }
            else if(array[mid]<low){
                low=mid+1;
            }

        }

    }

}
