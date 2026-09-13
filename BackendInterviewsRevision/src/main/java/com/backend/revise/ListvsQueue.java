package com.backend.revise;

import com.backend.revise.model.Student;

import java.util.*;
import java.util.stream.Collectors;

public class ListvsQueue {

    public static void main(String[] args) {
        //list allow duplicates
        Student s1 =new Student(100,"Kishan", Arrays.asList("Java","Spring","SpringBoot"));
        Student s2 =new Student(101,"Krishna", Arrays.asList("Cloud","AWS","Azure","GCP"));
        Student s3 =new Student(102,"Augustin", Arrays.asList("Owner","Spirt","Awsome"));
        Student s4 =new Student(103,"Niranjan", Arrays.asList("Kanchan","C++","Python"));

        List<Student> list =new ArrayList<>();
        list.add(s1);list.add(s2);
        list.add(s3);list.add(s4);
        System.out.println(list);


        //get the Queue
        //list.stream().map(s->s.subjects()).flatMap(List::stream)
        //                               .collect(Collectors.toCollection());

        List<String> list1 = list.stream().map(s->s.subjects()).flatMap(List::stream)
                                       .collect(Collectors.toList());
         Queue<String> queue =new LinkedList<>(list1);
        queue.add("ABC");
        queue.offer("XYZ");
        System.out.println(queue);

       System.out.print(queue.poll());

        System.out.println(queue.remove());
        System.out.println(queue);

        //get the peek element
        System.out.println(queue.peek());


    }
}
