package com.kk.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
   //http://localhost:8080/login/oauth2/code/google
    @GetMapping("/hello")
    public String greet(){
        return "Welcome TO Kishan , World!";
    }
}
