package com.job.github;

public class Test {

    public static void main(String[] args) throws Exception {
        Counter counter = new Counter();
        Thread t1 =new Thread(()->{
            for(int i=0;i<1000;i++){
                try
                {
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
              counter.increment();
            }
        });
        Thread t2 =new Thread(()->{
            for(int i=0;i<1000;i++){
                try
                {
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                counter.increment();
            }
        });
        t1.start();
        t2.start();

        Thread.sleep(100000);
        System.out.println(counter.getCount());
    }
}
