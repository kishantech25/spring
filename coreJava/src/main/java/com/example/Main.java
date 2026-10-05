package com.example;

import com.corejava.fundamental.FindLargestElement;
import com.corejava.fundamental.FindSecondLargestDistinctElement;
import com.corejava.fundamental.ReverseString;

public class Main {

    public static void main(String[] args) {

        int[] arr = {10, 20, 5, 40, 30};
        ReverseString reverseString =new ReverseString();
       String s=reverseString.reverseString("Kishan Kumar");
       System.out.println(s);

        FindLargestElement findLargestElement =new FindLargestElement();

        System.out.println(findLargestElement.findLargestElement(arr));

        findLargestElement.findLargestElement1(arr);
        FindSecondLargestDistinctElement element =new FindSecondLargestDistinctElement();
         System.out.println(element.secondLargestElement(arr));

    }
}
