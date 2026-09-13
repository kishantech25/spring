package com.backend.revise;

import com.sun.source.doctree.SystemPropertyTree;


import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class App {

    public static void main(String[] args) {
       //List
        List<String> names =new CopyOnWriteArrayList<>();
        names.add("Kishan");
        names.add("Rahul");
        names.add("Amit");

        System.out.println(names);

        //Set
        Set<String> cities =new HashSet<>();
        cities.add("Bangalore");
        cities.add("Rahul");
        cities.add("Bangalore");

        System.out.println("Set: "+cities);


        //Map
        Map<Integer,String> employees =new HashMap<>();
        employees.put(101,"John");
        employees.put(102,"Rahul");
        employees.put(102,"Ganesh");

        employees.entrySet().stream().forEach(entry->System.out.println(entry.getKey()+" : "+entry.getValue()));

        //Collections Algorithm
        Collections.sort(names);

        System.out.println("Sorted List : "+names);

    }
}
