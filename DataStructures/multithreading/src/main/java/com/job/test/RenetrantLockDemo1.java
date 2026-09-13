package com.job.test;

public class RenetrantLockDemo1 {

    public static void main(String[] args) {
        Display d =new Display();
        MyThread t1 =new MyThread(d,"Programmer");
        MyThread t2 =new MyThread(d,"Archetict");
        MyThread t3= new MyThread(d,"TeachLead");

        t1.start();
        t2.start();
        t3.start();
    }
}
