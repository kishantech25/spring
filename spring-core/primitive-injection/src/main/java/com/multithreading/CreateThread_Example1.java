package com.multithreading;

public class CreateThread_Example1 {

    public static Object sharedObject =new Object();
    public static void main(String[] args) {
        Thread objJob2 =new Thread(()->{
          System.out.println("job 2 is running");
        });
         objJob2.start();

         Runnable objRunable1 =()->{
             System.out.println("Job 3 is started");
             System.out.println(Thread.currentThread().getName());
             System.out.println(Thread.currentThread().getState());
             System.out.println(sharedObject.hashCode());
             try{
                 Thread.sleep(2000);
             }catch (InterruptedException e){
                 throw new RuntimeException();
             }
             System.out.println("job 3 completed");
         };

        Runnable objRunable2 =()->{
            System.out.println("Job 4 is started");
            System.out.println(Thread.currentThread().getName());
            System.out.println(Thread.currentThread().getState());
            System.out.println(sharedObject.hashCode());
            try{
                Thread.sleep(2000);
            }catch (InterruptedException e){
                throw new RuntimeException();
            }
            System.out.println("job 4 completed");
        };

         Thread objJob3=new Thread(objRunable1,"Runnable1 job");
         Thread objJob4=new Thread(objRunable2,"Runnable2 job");
         //make this job to running in background
        objJob3.setDaemon(true);
        objJob4.setDaemon(true);
        objJob3.start();
        objJob4.start();

        System.out.println("Main Job Ended");
    }
}
