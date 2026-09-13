package com.ds.multithreading;

import java.util.concurrent.*;

public class ThreadingDemo {

    public static void main(String[] args) throws InterruptedException{

        new Thread(()->{
            System.out.print("Hello ");
        }).start();

        Runnable task =()->{
            int result =101+100;

        };


        try {
            ExecutorService executor = Executors.newSingleThreadExecutor();
            Callable<Integer> task1=()->{
                Thread.sleep(5000);
                return 500;
            };
            Future<Integer> future= executor.submit(task1);
            System.out.println(future.get());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

    }
}
