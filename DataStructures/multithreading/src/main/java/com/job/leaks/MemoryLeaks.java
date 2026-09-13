package com.job.leaks;

import com.job.test.Employee;
import com.job.util.EmployeList;

import java.util.List;

public class MemoryLeaks {

    private static final ThreadLocal<Employee> DATA=new ThreadLocal<>();
   List<Employee> empList = EmployeList.employeList();
    public void process() {
    }
    public static void main(String[] args) {
       MemoryLeaks leaks=new MemoryLeaks();
       leaks.process();
    }

}
