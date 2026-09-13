package com.programatic;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class App {

    public static void main(String[] args) {

        BeanFactory factory =new XmlBeanFactory(new ClassPathResource("spring-bean-config-prog.xml"));

        //instantiate the object
        Calculater calculater =factory.getBean("calculater",Calculater.class);
        System.out.println(calculater);
    }
}
