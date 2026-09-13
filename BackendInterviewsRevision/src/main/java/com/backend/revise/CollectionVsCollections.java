package com.backend.revise;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CollectionVsCollections {

    public static void main(String[] args) {

        Collection<String> names =new ArrayList<>();
        names.add("Kishan");
        names.add("Rahul");
        names.add("Amit");

        System.out.println(names);

        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(8);
        list.add(15);
        list.add(12);


        //sort The list
        Collections.sort(list);
        System.out.println("Sorted List: "+list);

        //reverse the list
        Collections.reverse(list);;
        System.out.println("Reverse List: "+list);

        //Shuffle the list
        Collections.shuffle(list);
        System.out.println("Shuffle the List: "+list);
        System.out.println("Max value in list: "+Collections.max(list));
        System.out.println("Min Value in list: " +Collections.min(list));
    }
}
