package com.example;

import java.util.LinkedList;
import java.util.ListIterator;

public class ListIteratorDemo {
    public static void main(String[] args) {
        LinkedList l =new LinkedList();
        l.add("chru");
        l.add("balaiah");
        l.add("nag");
        l.add("venkey");
        System.out.println(l);

        ListIterator ltr =l.listIterator();

        while(ltr.hasNext()){
            String s =(String) ltr.next();
            if(s.equals("nag")){
                ltr.set("Nagesh");
            }
        }
        System.out.println(l);
    }
}
