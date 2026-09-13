package com.job;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLock2 {

    public static void main(String[] args) {
        ReentrantLock l =new ReentrantLock();
        l.lock();;
        l.lock();;
        System.out.println(l.isLocked()); //true
        System.out.println(l.isHeldByCurrentThread());
        l.unlock();
    }
}
