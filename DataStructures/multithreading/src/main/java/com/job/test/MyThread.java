package com.job.test;

public class MyThread  extends  Thread{
    Display d ;
    String name;
    MyThread(Display d,String name){
        this.d =d;
        this.name=name;
    }

    @Override
    public void run() {
        d.wishToNonRepaetedCharacter(name);
    }

}
