package com.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;

public class Calcuater implements BeanFactoryAware {

    private int num1;
    private  int num2;
    private int sum;

    @Override
    public String toString() {
        return "Calcuater{" +
                "num1=" + num1 +
                ", num2=" + num2 +
                ", sum=" + sum +
                '}';
    }

    public Calcuater(int num1){
        System.out.println("Constructor Called...");
        this.num1=num1;
    }
    public void setNum2(int num2){
        System.out.println("Setter() Method called");
        this.num2 =num2;
    }
    public void init(){
        System.out.println("init() Method called....");
        this.sum=this.num1 +this.num2;
        System.out.println("Sum of Num2 and Num2 is: "+sum);
    }
    public void shutDown(){
        System.out.println("Shutdown() called ....");
    }
    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
          System.out.println("SetFactory() method called....");
    }
}
