package com.job.oop;

import com.job.meta.Employer;
import com.job.meta.MyAnnotation;

import java.io.Serializable;
import java.util.List;


public class Employee implements Serializable ,Cloneable {

    private int id;
    private String name;
    private List<String> employees;

    @MyAnnotation("business")
    void work(){
        System.out.println(name+" is working.");
    }

    public Employee(int id, String name, List<String> employees) {
        this.id = id;
        this.name = name;
        this.employees = employees;
    }




    @Override
    public String toString() {
        return getClass().getSimpleName()+"@"+
                Integer.toOctalString(hashCode());

    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
