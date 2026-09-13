package com.nt.bpp;

import com.nt.beans.Employee;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class BackgroundVerificationBPP implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        if(bean instanceof Employee){
            Employee emp =(Employee) bean;
            System.out.println("Checking Background......");
            if(!emp.isBackgroundVerified()){
                throw new RuntimeException("background Verification Faild");
            }
            System.out.println("Backgrounf verified");
        }
        return bean;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
