package com.nt.statatistic;

import java.util.concurrent.atomic.AtomicInteger;

public class InstanceStaticstics {
    private static AtomicInteger instance=new AtomicInteger();

    public static void increment(){
        instance.getAndIncrement();
    }
    public static int getInstance(){
        return instance.get();
    }

}
