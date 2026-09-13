package com.nt.listener;

import com.nt.event.UserRegisteredEvent;
import org.springframework.stereotype.Component;

@Component
public class AuditListner {

    public void audit(UserRegisteredEvent event){
        System.out.println("Audit stored : "+event.getUserName());
    }

}
