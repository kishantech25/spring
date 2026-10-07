package com.ds.record;

import java.util.*;
import java.util.stream.Collectors;

record Employee11(int id, String name, String dept, int salary) {}

public class Main {
    public static void main(String[] args) {

        List<Employee11> employees = Arrays.asList(
                new Employee11(10, "Kishan", "IT", 10000),
                new Employee11(11, "Rakesh", "HR", 12000),
                new Employee11(12, "Kishan", "IT", 14000),
                new Employee11(13, "Sachin", "IT", 10000),
                new Employee11(14, "Mayank", "HR", 12000),
                new Employee11(15, "Rakesh", "IT", 18000)
        );

        Map<String, Integer> result = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee11::dept,
                        Collectors.mapping(
                                Employee11::salary,
                                Collectors.maxBy(Integer::compare)
                        )
                ))
                .entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        e -> e.getValue().get()
                ));
        result.entrySet().stream().forEach(entry->System.out.println(entry.getKey()+" :"+entry.getValue()));
    }
}