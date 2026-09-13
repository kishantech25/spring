package com.nt.listener;

import com.nt.event.UserRegisteredEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EmailListener {

    @EventListener
    public void sendWelcomeEmail(UserRegisteredEvent event){
        System.out.println("Welcome Email sent to : "+event.getUserma());
    }
}
