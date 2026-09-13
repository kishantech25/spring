package com.nt.security.controller;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

       @GetMapping("/hello")
       public String getHello(HttpServletRequest request){
           System.out.println(" getHello method called");
           return "Kishan Kumar ";
       }



}
