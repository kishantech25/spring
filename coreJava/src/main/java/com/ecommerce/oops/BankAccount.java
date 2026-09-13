package com.ecommerce.oops;

import java.util.UUID;

public abstract class BankAccount {

    private UUID txRefno;
    private String accountNo;
    private double balance;
    private String holderName;

    public BankAccount(String accountNo, double balance, String holderName) {
        this.txRefno = UUID.randomUUID();
        this.accountNo = accountNo;
        this.balance = balance;
        this.holderName = holderName;
    }

    public void deposit(double amount) {
        if(amount > 0){
            this.balance += amount;
        }
    }
    public abstract void withdraw(double amount);

    public double getBalance() {
        return balance;
    }
    protected void setBalance(double balance) {
        this.balance = balance;
    }



}
