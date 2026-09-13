package com.job;

public class ThreadC extends  Thread{
    long total=0;

    @Override
    public void run() {

        synchronized (this){
            System.out.println("Child thread starts calculation");
            for(int i=1;i<=100;i++){
                total*=i;
            }
            System.out.println("Child Thread giving notiifcation ");
            this.notify();
        }
    }
}
