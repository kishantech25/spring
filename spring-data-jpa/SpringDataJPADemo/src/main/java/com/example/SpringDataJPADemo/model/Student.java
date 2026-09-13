package com.example.SpringDataJPADemo.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "student")
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "roll_no")
    private int rollNo;
    @Column(name = "name")
    private String name;
    @Column(name = "marks")
    private double marks;

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", name='" + name + '\'' +
                ", marks=" + marks +
                '}';
    }


}
