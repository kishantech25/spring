package com.i18n.filter;

import org.springframework.context.annotation.Scope;

@Scope("singleton")
public class A {
    private B b;

    public void setB(B b){
        this.b=b;
    }
    public void show(){
        System.out.println(b);
    }
}
