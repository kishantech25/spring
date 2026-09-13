package com.job.scheduler;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecuterPOC {

    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                2,                      // corePoolSize
                4,                      // maximumPoolSize
                60,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(4),
                new ThreadPoolExecutor.AbortPolicy()
        );

        for (int i = 1; i <= 8; i++) {
            final int taskId = i;

            try {
                executor.execute(() -> {
                    String threadName = Thread.currentThread().getName();
                    System.out.println("Task-" + taskId + " started by " + threadName);

                    try {
                        Thread.sleep(3000); // keep thread busy so pool behavior is visible
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }

                    System.out.println("Task-" + taskId + " finished by " + threadName);
                });

                System.out.println("Submitted Task-" + taskId);
            } catch (RejectedExecutionException e) {
                System.out.println("Task-" + taskId + " rejected");
            }
        }

        executor.shutdown();
    }
}