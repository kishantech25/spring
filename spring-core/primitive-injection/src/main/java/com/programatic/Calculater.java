package com.programatic;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Calculater implements BeanFactoryAware, InitializingBean, DisposableBean {

    private int num1;
    private int num2;
    private int sum;

    public Calculater(int num1){
        System.out.println("constructor Called....");
        this.num1=num1;
    }

    @Override
    public String toString() {
        return "Calculater{" +
                "num1=" + num1 +
                ", num2=" + num2 +
                ", sum=" + sum +
                '}';
    }

    public void setNum2(int num2){
        System.out.println("setter() Method Called....");
        this.num2=num2;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
          System.out.println("Setter() Method called...");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy method called....");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertySet() Method Called....");
        this.sum=this.num1+this.num2;
        System.out.println("Sum of "+num1+" and "+num2+" is :"+sum);
    }
}
