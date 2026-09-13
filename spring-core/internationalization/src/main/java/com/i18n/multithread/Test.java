package com.i18n.multithread;

public class Test {

    public static void main(String[] args) throws InterruptedException{

        MyThread r1 =new MyThread();
        MyThread r2=new MyThread();

        Thread t1 =new Thread(r1);
        Thread t2 =new Thread(r2);

        t1.start();
        Thread.sleep(1000);
        t2.start();

    }

}
