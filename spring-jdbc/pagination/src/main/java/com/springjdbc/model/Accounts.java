package com.springjdbc.model;

import java.io.Serializable;

public class Accounts implements Serializable {
    protected int id;
    protected String accountHolderName;
    protected double balance;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Accounts{" +
                "id=" + id +
                ", accountHolderName='" + accountHolderName + '\'' +
                ", balance=" + balance +
                '}';
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
