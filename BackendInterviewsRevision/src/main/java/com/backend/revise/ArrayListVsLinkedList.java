package com.backend.revise;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListVsLinkedList {

    public static void main(String[] args) {

        List<String> list =new ArrayList<>();
        list.add("Java");
        list.add("Python");
        list.add("ShellScript");
        list.add("grovy");
        list.add("NodeJS");

        List<String> linkedlIst =new LinkedList<>(list);


        System.out.println(linkedlIst);
    }
}
