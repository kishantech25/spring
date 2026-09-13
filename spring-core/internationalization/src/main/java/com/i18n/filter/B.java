package com.i18n.filter;

import org.springframework.context.annotation.Scope;

@Scope("prototype")
public class B {

    private int i;
    public void setI(int i){
        this.i=i;
    }

    @Override
    public String toString() {
        return "B [i="+i+"]";
    }

}
