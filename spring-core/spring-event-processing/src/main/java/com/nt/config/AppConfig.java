package com.nt.config;

import com.nt.event.UserRegisteredEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAsync
public class AppConfig {

    @Bean
    public  UserRegisteredEvent getUserRegisteredEvent(){
        UserRegisteredEvent userRegistered =new UserRegisteredEvent("kishan");
         return userRegistered;
    }



}
