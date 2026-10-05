package com.example;

import java.util.Stack;

public class StackDemo {

    public static void main(String[] args) {
        Stack stack =new Stack();
        System.out.println(stack.empty());
        stack.push("A");
        stack.push("B");
        stack.push("C");
        System.out.println(stack);
        System.out.println(stack.search("A"));
        System.out.println(stack.search("Z"));

    }


}
