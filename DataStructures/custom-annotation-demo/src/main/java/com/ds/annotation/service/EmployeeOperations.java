package com.ds.annotation.service;

import com.ds.annotation.model.Employee;
import com.ds.annotation.model.Employees;

@FunctionalInterface
public interface EmployeeOperations {


    public Employees findEmployeeById(String employeeId);
}
