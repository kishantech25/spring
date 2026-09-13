package com.ds.annotation;


import com.ds.annotation.framework.AuthorizationProxy;
import com.ds.annotation.model.Employees;
import com.ds.annotation.service.EmployeeOperations;
import com.ds.annotation.service.EmployeeService;

import java.lang.reflect.Proxy;
public class Main {

    public static void main(String[] args) {

        EmployeeOperations employeeService =
                (EmployeeOperations) Proxy.newProxyInstance(
                        EmployeeOperations.class.getClassLoader(),
                        new Class[]{
                                EmployeeOperations.class
                        },
                        new AuthorizationProxy(
                                new EmployeeService()
                        )
                );

       Employees employe=employeeService.findEmployeeById("EMP-29808");

       System.out.println(employe);








    }
}
