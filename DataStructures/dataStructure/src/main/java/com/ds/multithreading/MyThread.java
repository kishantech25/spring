package com.ds.multithreading;

public class MyThread extends Thread{
    @Override
    public void run() {
        System.out.println("Running: "+Thread.currentThread().getName());
    }

}
