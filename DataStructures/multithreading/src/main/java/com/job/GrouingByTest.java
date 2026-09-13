package com.job;

import com.job.test.Employee;
import com.job.util.EmployeList;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class GrouingByTest {

    public static void main(String[] args) {

        List<Employee> employees = EmployeList.employeList();

        //Accumulate name into stream
        List<String> list =employees.stream().map(Employee::name).collect(Collectors.toList());

       // list.forEach(System.out::println);
      //Accumulte names into treeSet
        Set<String> set = employees.stream().map(Employee::name).collect(Collectors.toCollection(TreeSet::new));
       // set.forEach(System.out::println);
        set.stream().sorted((s1,s2)->s2.compareTo(s1)).forEach(System.out::println);
      //convert element to Strings and concatinate them,Seperated by commas

        String nameJoined =employees.stream()
                .map(Employee::name)
                .map(Object::toString).collect(Collectors.joining(","));
        System.out.println("Employe List::: "+nameJoined);

    }
}
