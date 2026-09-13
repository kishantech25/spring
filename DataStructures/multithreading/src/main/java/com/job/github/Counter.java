package com.job.github;

public class Counter {


    Object lock = new Object();

    private int count=0;
    void increment(){
        System.out.println(Thread.currentThread().getName() + " incrementing count: " + count);
        try
        {
          Thread.sleep(30);
        }catch(Exception e){
            e.printStackTrace();
        }
        synchronized (lock)
        {
            count++;
        }
    }
    public int getCount(){
        return count;
    }
}
