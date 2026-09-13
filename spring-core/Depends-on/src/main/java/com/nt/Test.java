package com.nt;

import com.nt.config.DependsOnConfig;
import com.nt.model.GetLoanDetails;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
       // ApplicationContext context =new ClassPathXmlApplicationContext("spring-bean-configuration.xml");
       ApplicationContext context =new AnnotationConfigApplicationContext(DependsOnConfig.class);

       GetLoanDetails details=context.getBean("getLoanDetails",GetLoanDetails.class);
        details.getLoanDetails(100000,30,"home","chennai");
    }
}
