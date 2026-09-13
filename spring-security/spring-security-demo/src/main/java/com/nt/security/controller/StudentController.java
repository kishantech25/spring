package com.nt.security.controller;

import com.nt.security.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class StudentController {

    List<Student> students =new ArrayList<>(List.of(
                  new Student(1,"Kishan","SpringBoot"),
                  new Student(2,"Rakesh","Devops")
    ));

    @GetMapping("students")
    public ResponseEntity<List<Student>> getStudents(){
          return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken)request.getAttribute("_csrf");
    }

    @PostMapping("students")
    public void addStduent(@RequestBody Student student){
        students.add(student);
    }
}
