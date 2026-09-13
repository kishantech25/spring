package com.job.meta;
import com.job.oop.Employee;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class MetaspaceDemo {

    public static void main(String[] args) throws Exception {


        //Employee e =new Employee(10,"Kishan", Arrays.asList("Java"));
        String className ="com.job.oop.Employee";

        Class<?> Claz=Class.forName(className);

        Employee e1=(Employee)Claz.getDeclaredConstructor().newInstance();

        System.out.println(e1);

        Class<?> clazz = e1.getClass();
        System.out.println(clazz.getName());

        var methods = clazz.getDeclaredMethods();

        for (var method : methods) {
            System.out.println(method.getName());
        }

        //Inspect Fileds
        var fileds = clazz.getDeclaredFields();
        for (var field : fileds) {
            System.out.println(field.getName()+" : "+field.getType());
        }

        //Inspect Constructors
        var constructors = clazz.getDeclaredConstructors();
        for (var constructor : constructors) {
            System.out.println(constructor.getName()+" : "+constructor.getParameterCount());
        }



        System.out.println("Application started");

        ExecutorService executor =
                Executors.newFixedThreadPool(5);

        // Start multiple application threads
        for (int i = 1; i <= 5; i++) {

            int threadNumber = i;

            executor.submit(() -> {

                String threadName =
                        Thread.currentThread().getName();

                System.out.println(
                        threadName +
                                " started - Business processing"
                );

                for (int i1 = 0; i1 < 10; i1++) {

                    Account account =
                            new Account(
                                    threadNumber,
                                    "Account-" + i1
                            );

                    account.process();

                    sleep(1000);
                }

                System.out.println(
                        threadName +
                                " completed"
                );
            });
        }

        executor.shutdown();

        executor.awaitTermination(
                1,
                TimeUnit.MINUTES
        );

        System.out.println(
                "All business threads completed"
        );

        System.out.println(
                "Loaded classes = "
                        + getLoadedClassCount()
        );

        System.out.println(
                "Application finished"
        );
    }

    private static long getLoadedClassCount() {

        return java.lang.management
                .ManagementFactory
                .getClassLoadingMXBean()
                .getLoadedClassCount();
    }

    private static void sleep(long millis) {

        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {

            Thread.currentThread().interrupt();
        }
    }
}