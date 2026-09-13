package com.job;

import com.job.test.Employee;
import com.job.util.EmployeList;

import java.util.*;
import java.util.stream.Collectors;

public class CollectorsBasedExample {

    public static void main(String[] args) {

        //Collectors based example

       List<Employee> employees = EmployeList.employeList();
        //How many employees are each department
        Map<String,Long> employeByDepartment=employees.stream().collect(Collectors.groupingBy(Employee::department,Collectors.counting()));

        employeByDepartment.forEach((k,v)->System.out.println(k+" : "+v));

        //average salary by deprtment wise


        //with out  stream Api
      // Map<String,Double> findAvgSalryBydeprt=findAvgSalaryByDeprtment(employees);
        //with Stream API
         Map<String,Double> findAvgSalryBydeprt = employees.stream().
                 collect(Collectors.groupingBy(
                         Employee::department,
                         Collectors.averagingDouble(
                                 Employee::salary)));


       //  Map<String,List<String>> findEachDepartmentEmployeList=employees.stream()
       //                  .collect(Collectors.groupingBy(Employee::department,Collectors.mapping(Employee::name,Collectors.toList())));
        Map<String,List<String>> findEachDepartmentEmployeList = findEachDepartmentEmployeList(employees);
         findEachDepartmentEmployeList.forEach((k,v)->System.out.println(k+" : "+v));
      // findAvgSalryBydeprt.forEach((k,v)->System.out.println(k+" : "+v));

    }
    public static Map<String,Double> findAvgSalaryByDeprtment(List<Employee> employees) {
        double avg = 0.0;

        String deprt = null;
        Map<String, Double> avgSalaryByDeprtment = new HashMap<>();
        String deprtment=null;
        for (Employee e : employees) {
            //get department
            deprtment = e.department();

            if (employees.contains(deprtment)) {
                continue;
            }
            int sum =0;
            int count = 0;
            for (Employee emp : employees) {
                if (emp.department().equals(deprtment)) {
                    sum+=e.salary();
                    count++;
                }
            }
            avg = (double) sum / count;
            avgSalaryByDeprtment.put(deprtment, avg);
        }
        return avgSalaryByDeprtment;
    }

    public static Map<String,List<String>> findEachDepartmentEmployeList(List<Employee> employees){

        Map<String,List<String>> result = new HashMap<>();

          for(Employee e:employees){
              String department = e.department();

              if(e.department().contains(department)){
                  continue;
              }
              List<String> employeList =new ArrayList<>();
              for(Employee emp:employees){
                  if(emp.department().equals(department)){
                      employeList.add(emp.name());
                  }
              }
              result.put(department,employeList);
          }
          return result;
    }
}
