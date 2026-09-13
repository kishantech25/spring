package com.ds.multithreading.futureTAsk;

import java.util.concurrent.Callable;

public class BankingCalculater implements Callable<Double> {
    @Override
    public Double call() throws Exception {
        System.out.print("Balance calculated Started ....");
        Thread.sleep(20000);
        double balance =150000.75;
        System.out.println("Balance Calculated");
        return balance;
    }
}
