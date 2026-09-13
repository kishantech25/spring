package com.nt;

import com.nt.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
    //    ApplicationContext context=new ClassPathXmlApplicationContext("spring-bean-configuration.xml");
       ApplicationContext context =new AnnotationConfigApplicationContext(AppConfig.class);
        context.getBean("user")
    }
}
