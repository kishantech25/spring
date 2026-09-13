package com.nt.processer;

import com.nt.vo.ObjectVo;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.util.Date;

public class ValueObjectBeanPostProcesser implements BeanPostProcessor {
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof ObjectVo){
            ((ObjectVo) bean).setCreateDate(new Date());
            ((ObjectVo) bean).setInstModifiedDate(new Date());
        }
        return bean;
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
