package com.nt;

import com.nt.beans.Employee;
import com.nt.bpp.BackgroundVerificationBPP;
import com.nt.bpp.DocumentVerifiactionBPP;
import com.nt.bpp.HRApprovalBPP;
import com.nt.bpp.MedicalVerificationBPP;
import org.springframework.beans.factory.BeanFactory;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

public class Test {

    public static void main(String[] args) {

        BeanFactory factory =new XmlBeanFactory(new ClassPathResource("spring-bean-configuration.xml"));

        BeanPostProcessor doc=factory.getBean("doc", DocumentVerifiactionBPP.class);
        ((ConfigurableListableBeanFactory)factory).addBeanPostProcessor(doc);
        BeanPostProcessor bg=factory.getBean("bg", BackgroundVerificationBPP.class);
        ((ConfigurableListableBeanFactory)factory).addBeanPostProcessor(bg);
        BeanPostProcessor medical=factory.getBean("medical", MedicalVerificationBPP.class);
        ((ConfigurableListableBeanFactory)factory).addBeanPostProcessor(medical);
        BeanPostProcessor hr=factory.getBean("hr", HRApprovalBPP.class);
        ((ConfigurableListableBeanFactory)factory).addBeanPostProcessor(hr);

        Employee emp=factory.getBean("emp",Employee.class);

        System.out.println(emp);


    }
}
