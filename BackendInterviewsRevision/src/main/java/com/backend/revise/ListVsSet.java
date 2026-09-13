package com.backend.revise;

import com.backend.revise.model.Student;

import java.util.*;
import java.util.stream.Collectors;

public class ListVsSet {

    public static void main(String[] args) {

        //list allow duplicates
        Student s1 =new Student(100,"Kishan", Arrays.asList("Java","Spring","SpringBoot"));
        Student s2 =new Student(101,"Krishna", Arrays.asList("Java","AWS","Azure","GCP"));
        Student s3 =new Student(102,"Augustin", Arrays.asList("Hadoop","Java","Swagger"));
        Student s4 =new Student(103,"Niranjan", Arrays.asList("Cloud","C++","Python"));

        List<Student> list =Arrays.asList(s1,s2,s3,s4);

       List<String> subjects=  list.stream().map(s->s.subjects()).flatMap(List::stream)
                                            .collect(Collectors.toList());
         System.out.println(subjects);
        //set does not allow duplicates
          //remove the duplicates
        Set<String> set =subjects.stream().collect(Collectors.toSet());

        System.out.println(set);


    }
}
