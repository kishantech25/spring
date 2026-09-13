package com.job.scheduler;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecuterDemo {



    public static void main(String[] args) {
        ThreadPoolExecutor executor =
                new ThreadPoolExecutor(
                        2,
                        4,
                        60,
                        TimeUnit.SECONDS,
                        new ArrayBlockingQueue<>(2)
                );

        executor.execute(() -> System.out.println("Task 1 is running"));
        executor.execute(() -> System.out.println("Task 2 is running"));

        executor.shutdown();

    }

}
