package com.nt.bpp;

import com.nt.beans.Employee;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MedicalVerificationBPP implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean,String beanName){

        if(bean instanceof Employee){

            Employee emp=(Employee)bean;

            System.out.println("Medical Test...");

            if(!emp.isMedicalCleared()){

                throw new RuntimeException("Medical Failed");

            }

            System.out.println("Medical Cleared");

        }

        return bean;

    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}