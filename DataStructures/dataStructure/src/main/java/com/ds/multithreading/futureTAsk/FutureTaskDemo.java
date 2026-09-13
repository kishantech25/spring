package com.ds.multithreading.futureTAsk;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class FutureTaskDemo {

    public static void main(String[] args) {

        Callable<Double> callable =new BankingCalculater();
        FutureTask<Double> futureTask =new FutureTask<>(callable);
        Thread workerThread = new Thread(futureTask);
        workerThread.start();
        System.out.println("Main Thread is free to do other work");

        try{
            for(int i=0;i<=5;i++){
                System.out.println("Main Thread Working... "+i);
                Thread.sleep(1000);

            }
            System.out.println("\n waiting for Balance.....");
            Double balance =futureTask.get();

            System.out.println("\n Available Balance = "+balance);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("Application Finished..");
    }
}
