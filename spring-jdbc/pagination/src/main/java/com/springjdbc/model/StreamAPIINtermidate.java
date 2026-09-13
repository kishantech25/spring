package com.springjdbc.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StreamAPIINtermidate {

    public static void main(String[] args) {

        //find duplicate Elements in List
        List<Integer>  list = Arrays.asList(1,2,3,4,5,6,7,8,9);

        Set<Integer> unique =new HashSet<>();
        list.stream()
                .filter(n->!unique.add(n))
                .forEach(System.out::println);

    }


}
