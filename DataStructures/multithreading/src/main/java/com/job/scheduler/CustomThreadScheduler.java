package com.job.scheduler;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Custom Thread Scheduler - Controls all threads in the application
 * Similar to JVM's thread scheduler but at application level
 */
public class CustomThreadScheduler {

    private static final int DEFAULT_POOL_SIZE = 10;
    private static final int QUEUE_CAPACITY = 1000;

    private final BlockingQueue<ScheduledTask> taskQueue;
    private final List<WorkerThread> workerThreads;
    private final AtomicInteger activeThreads;
    private final AtomicInteger completedTasks;
    private final AtomicInteger failedTasks;
    private volatile boolean isRunning;
    private final ThreadSchedulingPolicy schedulingPolicy;

    // Scheduling policies
    public enum ThreadSchedulingPolicy {
        FIFO,           // First In First Out
        PRIORITY,       // Based on task priority
        ROUND_ROBIN     // Round-robin scheduling
    }

    public CustomThreadScheduler(int poolSize, ThreadSchedulingPolicy policy) {
        this.taskQueue = new PriorityBlockingQueue<>(QUEUE_CAPACITY, 
            policy == ThreadSchedulingPolicy.PRIORITY ? 
            Comparator.comparingInt(ScheduledTask::getPriority).reversed() :
            Comparator.comparingLong(ScheduledTask::getEnqueueTime)
        );
        
        this.workerThreads = new ArrayList<>();
        this.activeThreads = new AtomicInteger(0);
        this.completedTasks = new AtomicInteger(0);
        this.failedTasks = new AtomicInteger(0);
        this.isRunning = true;
        this.schedulingPolicy = policy;

        // Initialize worker threads
        for (int i = 0; i < poolSize; i++) {
            WorkerThread worker = new WorkerThread("CustomWorker-" + i);
            workerThreads.add(worker);
            worker.start();
        }

        System.out.println("✓ Custom Thread Scheduler initialized with " + poolSize + 
                         " threads using " + policy + " policy");
    }

    // ======================== Task Submission ========================
    public Future<String> submit(Runnable task) {
        return submit(task, 5); // Default priority 5
    }

    public Future<String> submit(Runnable task, int priority) {
        if (!isRunning) {
            throw new RejectedExecutionException("Scheduler is shut down");
        }

        ScheduledTask scheduledTask = new ScheduledTask(task, priority);
        try {
            taskQueue.put(scheduledTask);
            return scheduledTask.getFuture();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RejectedExecutionException("Task submission interrupted", e);
        }
    }

    // ======================== Worker Thread ========================
    private class WorkerThread extends Thread {
        private long totalExecutionTime = 0;
        private int tasksExecuted = 0;

        public WorkerThread(String name) {
            super(name);
            setDaemon(false);
        }

        @Override
        public void run() {
            while (isRunning) {
                try {
                    ScheduledTask task = taskQueue.poll(5, TimeUnit.SECONDS);

                    if (task != null) {
                        activeThreads.incrementAndGet();
                        long startTime = System.currentTimeMillis();

                        try {
                            System.out.println("[SCHEDULED] " + Thread.currentThread().getName() + 
                                             " executing: " + task.getTaskName() + 
                                             " (Priority: " + task.getPriority() + ")");
                            
                            task.getRunnable().run();
                            
                            long executionTime = System.currentTimeMillis() - startTime;
                            totalExecutionTime += executionTime;
                            tasksExecuted++;
                            completedTasks.incrementAndGet();

                            System.out.println("[COMPLETED] " + Thread.currentThread().getName() + 
                                             " finished task in " + executionTime + "ms");
                            
                            task.complete("Task completed successfully");

                        } catch (Exception e) {
                            failedTasks.incrementAndGet();
                            System.err.println("[ERROR] " + Thread.currentThread().getName() + 
                                             " failed: " + e.getMessage());
                            task.completeExceptionally(e);
                        } finally {
                            activeThreads.decrementAndGet();
                        }
                    }

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    if (!isRunning) {
                        break;
                    }
                }
            }
            System.out.println("[SHUTDOWN] " + Thread.currentThread().getName() + 
                             " stopped. Tasks executed: " + tasksExecuted);
        }

        public String getStats() {
            return String.format("Tasks: %d, Avg Time: %.2fms", 
                tasksExecuted, tasksExecuted > 0 ? totalExecutionTime / (double) tasksExecuted : 0);
        }
    }

    // ======================== Scheduled Task ========================
    static class ScheduledTask implements Comparable<ScheduledTask> {
        private final Runnable runnable;
        private final int priority;
        private final long enqueuTime;
        private final CompletableFuture<String> future;
        private final String taskName;

        public ScheduledTask(Runnable runnable, int priority) {
            this.runnable = runnable;
            this.priority = priority;
            this.enqueuTime = System.currentTimeMillis();
            this.future = new CompletableFuture<>();
            this.taskName = runnable.getClass().getSimpleName();
        }

        public Runnable getRunnable() { return runnable; }
        public int getPriority() { return priority; }
        public long getEnqueueTime() { return enqueuTime; }
        public CompletableFuture<String> getFuture() { return future; }
        public String getTaskName() { return taskName; }

        public void complete(String result) { future.complete(result); }
        public void completeExceptionally(Exception e) { future.completeExceptionally(e); }

        @Override
        public int compareTo(ScheduledTask other) {
            return Integer.compare(other.priority, this.priority);
        }
    }

    // ======================== Monitoring & Stats ========================
    public void printStats() {
        System.out.println("\n===== SCHEDULER STATISTICS =====");
        System.out.println("Scheduling Policy: " + schedulingPolicy);
        System.out.println("Active Threads: " + activeThreads.get());
        System.out.println("Completed Tasks: " + completedTasks.get());
        System.out.println("Failed Tasks: " + failedTasks.get());
        System.out.println("Pending Tasks: " + taskQueue.size());
        System.out.println("\nThread Details:");
        for (WorkerThread worker : workerThreads) {
            System.out.println("  - " + worker.getName() + ": " + worker.getStats());
        }
        System.out.println("================================\n");
    }

    // ======================== Shutdown ========================
    public void shutdown() {
        isRunning = false;
        System.out.println("Scheduler shutting down...");
    }

    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        long deadline = System.currentTimeMillis() + unit.toMillis(timeout);
        
        for (WorkerThread worker : workerThreads) {
            long remaining = deadline - System.currentTimeMillis();
            if (remaining <= 0) return false;
            worker.join(remaining);
        }
        return true;
    }
}
