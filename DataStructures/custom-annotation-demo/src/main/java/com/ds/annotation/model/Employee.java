package com.ds.annotation.model;

public class Employee {


    private int id;
    private String name;
    private double salary;

    private User user;

    public Employee(String name, double salary, User user) {
        this.name = name;
        this.salary = salary;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
