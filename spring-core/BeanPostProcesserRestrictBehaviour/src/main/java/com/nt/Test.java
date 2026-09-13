package com.nt;

import com.nt.controller.ValueObjectController;
import com.nt.processer.ValueObjectBeanPostProcesser;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class Test {

    public static void main(String[] args) {

        BeanFactory factory =new XmlBeanFactory(new ClassPathResource("spring-bean-configuration.xml"));

        //call the inspector bean to provide duty to check the been before entring into IOC container
        BeanPostProcessor processor =factory.getBean("valueObjectBeanPostProcesser", ValueObjectBeanPostProcesser.class);

        ((ConfigurableListableBeanFactory)factory).addBeanPostProcessor(processor);


     //create the controller bean who is controlling the projectVo been
        ValueObjectController controller=factory.getBean("valueObjectController",ValueObjectController.class);

        controller.getValue(111,"realspeed","cipla","in progress");


    }
}
