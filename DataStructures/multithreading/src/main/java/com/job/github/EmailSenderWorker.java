package com.job.github;

public class EmailSenderWorker implements Runnable {

    private volatile boolean runnig =true; //stop signal visibblity

    public void stopWorker(){

        runnig=false;
        System.out.println("Running by stop Method"+Thread.currentThread().getName());
        System.out.println("EmailSenderWorker stop");
    }

    @Override
    public void run() {
        int count = 0;
      while(runnig){
          //poll que and send emails
          System.out.println("Running by run method "+Thread.currentThread().getName());
          System.out.println("Sending pending emails......"+count++);
          try
          {
              Thread.sleep(100);

          }catch(InterruptedException e){
              Thread.currentThread().interrupt();
              break;
          }

      }

    }
}
