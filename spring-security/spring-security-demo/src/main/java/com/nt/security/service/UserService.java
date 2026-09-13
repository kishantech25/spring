package com.nt.security.service;

import com.nt.security.model.User;
import com.nt.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public User saveUser(User user){
        user.setPassword(encoder.encode(user.getPassword()));
        System.out.println(user.getPassword());
        return userRepository.save(user);
    }
}
