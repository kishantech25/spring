package com.ds.texBlocks;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamApiEnhancement {

    public static void main(String[] args) {

        String name=null;

       // Stream.ofNullable(name).forEach(System.out::println);

        List<Integer> list = Arrays.asList(10,20,30,40,50,60,70,87);

        List<Integer>whileList= list.stream().takeWhile(i->i<50).collect(Collectors.toList());

      //  whileList.forEach(System.out::println);

        //get even no until found odd,
        List<Integer> l =List.of(2,4,6,8,1,10,12);

        List<Integer> evenNo =l.stream().takeWhile(i->i%2==0).collect(Collectors.toList());
       // evenNo.forEach(System.out::println);

        List<String> names =List.of("A","B","C","D","Java","Python","K","L");
       List<String> singleChar= names.stream().takeWhile(s->s.length() ==1).collect(Collectors.toList());
        singleChar.forEach(System.out::println);








    }
}
