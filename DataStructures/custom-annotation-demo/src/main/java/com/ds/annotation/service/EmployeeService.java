package com.ds.annotation.service;

import com.ds.annotation.annotation.Authorized;
import com.ds.annotation.model.Employees;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.List;
import java.util.Optional;

public class EmployeeService implements EmployeeOperations {

    @Override
    public Employees findEmployeeById(String employeeId) {

        Optional<Employees> employe=getEmployees().stream().filter(emp->emp.id().equals(employeeId)).findFirst();//.orElseThrow(()->new RuntimeException("Employee not found"));
        return employe.get();
    }


    public List<Employees> getEmployees() {
        try {

            ObjectMapper mapper = new ObjectMapper();

            JsonNode root = mapper.readTree(
                    new File("C:/Users/KISHANTECH/Spring/DataStructures/custom-annotation-demo/src/main/resources/employees.json")
            );

            JsonNode employeesNode = root.get("employees");
                  System.out.println();
                  String json =employeesNode.toString();
                 ObjectMapper objectMapper =new ObjectMapper();
            JavaType type = objectMapper.getTypeFactory()
                    .constructCollectionType(List.class, Employees.class);

            List<Employees> employeesList = objectMapper.readValue(json, type);

            return employeesList;
        } catch (Exception e) {

            throw new RuntimeException(
                    "Unable to read employee JSON file", e
            );
        }
    }

}
