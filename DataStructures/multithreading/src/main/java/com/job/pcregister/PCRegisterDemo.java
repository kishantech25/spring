package com.job.pcregister;

import java.util.Arrays;
import java.util.List;

public class PCRegisterDemo {

    public static void main(String[] args) {
        List<String> accounts= Arrays.asList(
                "Account-1",
                "Account-2",
                "Account-3",
                "Account-4",
                "Account-5"
        );
      int i=0;
      for(String account:accounts){

          Thread thread = new Thread(
                  ()->processAccount(account),"Bank-Account "+i
          );
          thread.start();
          i++;
      }
    }
    static void processAccount(String accountNumber) {

        System.out.println(
                Thread.currentThread().getName()
                        + " : START "
                        + accountNumber
        );

        int balance = loadBalance(accountNumber);

        int transaction = calculateTransaction(balance);

        updateBalance(accountNumber, transaction);

        System.out.println(
                Thread.currentThread().getName()
                        + " : END "
                        + accountNumber
        );
    }

    static int loadBalance(String accountNumber) {

        System.out.println(
                Thread.currentThread().getName()
                        + " : Loading balance for "
                        + accountNumber
        );

        return 10000;
    }

    static int calculateTransaction(int balance) {

        int transactionAmount = 2000;

        return balance - transactionAmount;
    }

    static void updateBalance(
            String accountNumber,
            int newBalance) {

        System.out.println(
                Thread.currentThread().getName()
                        + " : Updating "
                        + accountNumber
                        + " → "
                        + newBalance
        );
    }
}
