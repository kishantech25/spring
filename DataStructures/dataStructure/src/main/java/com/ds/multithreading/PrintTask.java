package com.ds.multithreading;

public class PrintTask implements Runnable{


    @Override
    public void run() {
        System.out.println("Runnning: "+Thread.currentThread().getName());
    }
}
