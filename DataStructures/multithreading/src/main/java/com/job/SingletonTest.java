package com.job;

import com.job.singleton.DateUtil;

public class SingletonTest {

    public static void main(String[] args) {

        Runnable runnable = ()-> {
           DateUtil date= DateUtil.getInstance();
           System.out.println(date.hashCode());

        };
        Runnable runnable1 = ()-> {
            DateUtil date =DateUtil.getInstance();
            System.out.println(date.hashCode());
        };
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable1);

        thread1.start();
        thread2.start();


    }
}
