package com.job.casestudy;

import java.math.BigInteger;

public class Main2 {

    public static void main(String[] args) {
    Thread thread =new Thread(new BlockingTask());
    thread.start();
    thread.interrupt();

    }
    private static class BlockingTask implements  Runnable{

        @Override
        public void run() {
            try{
                Thread.sleep(50000);
            }catch (InterruptedException e){
                System.out.println("Existing blocking thread");
            }
        }
    }
    private static class LongCompuationTask implements  Runnable{
        private BigInteger base;
        private BigInteger power;

        public LongCompuationTask(BigInteger base,BigInteger ppwer){
            this.base=base;
            this.power=power;
        }

        @Override
        public void run() {
            System.out.println(base+"^");
        }
    }

}
