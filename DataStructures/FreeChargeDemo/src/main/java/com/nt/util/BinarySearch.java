package com.nt.util;

public class BinarySearch {

    public static void main(String[] args) {
        int arr[]={10,20,30,40,50,60,70,80};
        int target=50;
       binarySearch(arr,target);

    }
    public static void binarySearch(int []arr,int target){
        int min = arr[0];
        int max = arr[arr.length -1];
        int mid =(min+max)/2;

        int index=0;
        while(mid>min && mid<max)
        {
            min =arr[index+1];
            max =arr[arr.length-(index+1)];
            mid = min + max /2;
            if(min == target){
                System.out.println("value is available "+min);
                break;
            }else{
                System.out.println("value is  available "+max);
                break;
            }
        }
    }
}
