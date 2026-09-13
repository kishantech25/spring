package com.job.github;

import com.job.BooksDao;

public class Worker implements Runnable {
       private volatile boolean running = true;

       public void stop() {
           this.running = false;
           System.out.println("Worker is stopped");
       }
    @Override
    public void run() {
       while (this.running) {

           System.out.println("Worker is running");
           try {
               Thread.sleep(300);
           } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;

           }
       }
    }
}
