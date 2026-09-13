package com.ds.multithreading.executerService;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ExecuterServiceDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        CompletableFuture<String> future1 =CompletableFuture.supplyAsync(()->{
           try{
               Thread.sleep(3000);
           }catch (Exception e){}

           return "Hello Java";
        });

        System.out.println("Main Thread Is free");
        System.out.println(future1.get());
        CompletableFuture<Integer> future2 =CompletableFuture.supplyAsync(()->100);
        System.out.println(future2.get());

        CompletableFuture<Integer> future3=CompletableFuture.supplyAsync(()->100)
                .thenApply(x->x*10);
        System.out.println(future3.get());

        CompletableFuture<Void> future4=CompletableFuture.supplyAsync(()->"Java").thenAccept(System.out::println);
          future4.get();
    }


}
