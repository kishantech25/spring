package com.job.scheduler;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Demo: How to use CustomThreadScheduler
 * Shows controlling 100 threads with your custom scheduler
 */
public class CustomSchedulerDemo {

    public static void main(String[] args) throws Exception {
        System.out.println("===== CUSTOM THREAD SCHEDULER DEMO =====\n");

        // Create scheduler with PRIORITY policy and 10 worker threads
        CustomThreadScheduler scheduler = new CustomThreadScheduler(10, 
            CustomThreadScheduler.ThreadSchedulingPolicy.PRIORITY);

        System.out.println("Submitting 100 tasks to scheduler...\n");

        // Submit 100 tasks (simulating 100 threads in your app)
        for (int i = 1; i <= 100; i++) {
            int taskId = i;
            int priority = (i % 10) + 1; // Priority 1-10 (higher = more important)
            
            // Submit task with priority
            scheduler.submit(() -> {
                simulateAppTask(taskId);
            }, priority);
        }

        // Let tasks process
        Thread.sleep(5000);
        scheduler.printStats();

        // Submit some URGENT tasks (priority 20)
        System.out.println("\n✓ Submitting 10 URGENT tasks...\n");
        for (int i = 101; i <= 110; i++) {
            int taskId = i;
            scheduler.submit(() -> {
                simulateAppTask(taskId);
            }, 20); // High priority
        }

        Thread.sleep(5000);
        scheduler.printStats();

        // Graceful shutdown
        System.out.println("\n▶ Initiating graceful shutdown...");
        scheduler.shutdown();
        
        if (scheduler.awaitTermination(15, TimeUnit.SECONDS)) {
            System.out.println("✓ All tasks completed, scheduler terminated gracefully");
        } else {
            System.out.println("✗ Timeout: Some tasks still running");
        }

        scheduler.printStats();
    }

    private static void simulateAppTask(int taskId) {
        try {
            Thread.sleep(new Random().nextInt(300) + 100);
            System.out.println("  ✓ Task-" + taskId + " completed on " + 
                             Thread.currentThread().getName());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
