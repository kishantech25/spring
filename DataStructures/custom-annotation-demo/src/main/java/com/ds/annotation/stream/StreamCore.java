package com.ds.annotation.stream;

import com.ds.annotation.model.Employee;
import com.ds.annotation.model.Employees;
import com.ds.annotation.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.stream.Collectors;

public class StreamCore {

    public static void main(String[] args) throws Exception {
        EmployeeService employeService=new EmployeeService();

        List<Employees> employees=employeService.getEmployees();
        ObjectMapper mapper = new ObjectMapper();

        //1.find all active employees

     //  List<Employees> list= employees.stream().filter(Employees::isActive).collect(Collectors.toList());
         //count it

      // list.forEach(System.out::println);
      //  System.out.println(list.stream().count());

        System.out.println("2. Find employees earning more than 80,000");
       // employees.stream().filter(emp->emp.salary()>80000).forEach(System.out::println);
        System.out.println("===============================");

        System.out.println("3. Find employees in the 'Engineering' department");
      //  employees.stream().filter(emp->emp.department().equals("Engineering")).forEach(System.out::println);
        System.out.println("==============================");

        System.out.println("4. Find in Active employee");

     //   employees.stream().filter(Employees::isActive).forEach(System.out::println);

        System.out.println("==============================");
        System.out.println("5. Extract Employe First Name");
     //   employees.stream().map(Employees::firstName).forEach(System.out::println);
        System.out.println("==============================");
        System.out.println("6. Extract Employe Email Address");

     //   employees.stream().map(Employees::email).forEach(System.out::println);

        System.out.println("==============================");

        System.out.println("7. Extract Employe Ids");

     //   employees.stream().map(Employees::id).forEach(System.out::println);

        System.out.println("==============================");

        //Find Engineering employe earning 90+
    //    System.out.println("8. Find Engineering employee earning 90+");

//        employees.stream().filter(emp->emp.department().equals("Engineering"))
//                .filter(emp->emp.salary()>90000)
//                .forEach(System.out::println);

         System.out.println("==============================");

         System.out.println("9. Find Active Software Engineers");

        String json=mapper.writeValueAsString(employees.stream().filter(Employees::isActive)
                 .filter(emp->emp.role().equals("Software Engineer")).collect(Collectors.toList()));
            System.out.println(json);
         System.out.println("==============================");

         System.out.println("10. Write a employe whose first name start with A");

         System.out.println(employees.stream().filter(emp->emp.firstName().startsWith("A"))).
         System.out.println("==============================");



    }
}
