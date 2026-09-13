package com.nt.service;

import com.nt.event.UserRegisteredEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private ApplicationEventPublisher publisher;

    public void registerUser(String username){
        System.out.println("User Registers");
        publisher.publishEvent(new UserRegisteredEvent(username));
    }

}
