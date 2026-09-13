package com.example.SpringDataJPADemo.repository;

import com.example.SpringDataJPADemo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {


    public List<Student> findByName(String name);
}
