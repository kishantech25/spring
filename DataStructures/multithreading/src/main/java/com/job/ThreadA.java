package com.job;

public class ThreadA
{
    public static void main(String[] args) throws InterruptedException{
         ThreadB b =new ThreadB();
         ThreadC c =new ThreadC();
         synchronized(b)
         {
             System.out.println("main thread calling wait method");
             b.wait();
             System.out.println("main thread got notification");
             System.out.println(b.total);
         }
    }
}
