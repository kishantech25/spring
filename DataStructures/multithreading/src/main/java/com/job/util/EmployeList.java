package com.job.util;

import com.job.test.Employee;

import java.util.Arrays;
import java.util.List;

public class EmployeList {

    public static List<Employee> employeList(){
        Employee e1 =new Employee(101,"Kishan","IT",120000);
        Employee e2 =new Employee(102,"Rakesh","HR",100000);
        Employee e3 =new Employee(103,"Suresh","Finance",70000);

        Employee e4 =new Employee(104,"Rahul","IT",140000);
        Employee e5 =new Employee(105,"Ganesh","IT",80000);
        Employee e6 =new Employee(106,"Nagendra","HR",70000);
        Employee e7 =new Employee(107,"niranjan","Finance",50000);

        List<Employee> employees = Arrays.asList(e1,e2,e3,e4,e5,e6,e7);
        return employees;
    }
}
