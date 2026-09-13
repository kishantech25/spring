package com.nt.security.controller;

import com.nt.security.model.User;
import com.nt.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    AuthenticationManager authenticationManager;

    @PostMapping("register")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        User users =userService.saveUser(user);
        return new ResponseEntity<>(users,HttpStatus.CREATED);
    }

    @PostMapping("login")
    public String login(@RequestBody User user){
        Authentication authentication =authenticationManager.
                authenticate(new UsernamePasswordAuthenticationToken(
                        user.getUsername(),user.getPassword()));

          if(authentication.isAuthenticated()){
              return "successful";
          }else{
              return "Failed";
          }

    }

}
