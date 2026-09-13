package com.nt.bpp;

import com.nt.beans.Employee;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class DocumentVerifiactionBPP implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof Employee){
            Employee emp = (Employee) bean;
             System.out.println("Checking Documents ....");
             if(!emp.isDocumentsVerified()){
                 throw new RuntimeException("Document Verification Faild");
             }
             System.out.println("Dcoumnets verified");
        }
        return bean;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
