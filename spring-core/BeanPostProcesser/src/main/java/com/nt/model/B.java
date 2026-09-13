package com.nt.model;

public class B {
    private C c;
    public B(C c){
        System.out.print("B Object Created");
        this.c=c;
    }

    public C getC() {
        return c;
    }

    public void setC(C c) {
        this.c = c;
    }
}
