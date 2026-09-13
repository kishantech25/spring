package com.ds.annotation.model;

import java.util.List;

public record Employees(String id, String firstName, String lastName, String email, String phone,String hireDate,
                        String department, String role, int salary, boolean isActive, List<String> skills) {
}
