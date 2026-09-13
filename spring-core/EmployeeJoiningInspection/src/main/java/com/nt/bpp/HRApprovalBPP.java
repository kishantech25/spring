package com.nt.bpp;

import com.nt.beans.Employee;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class HRApprovalBPP implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean,String beanName){

        if(bean instanceof Employee){

            System.out.println("HR Approved");
            System.out.println("Employee Allowed To Join");

        }
        return bean;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}