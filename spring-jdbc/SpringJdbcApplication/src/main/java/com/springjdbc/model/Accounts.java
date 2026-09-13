package com.springjdbc.model;



public class Accounts {

   private int accountId;
   private String accountNumber;
   private String name;
   private String pincode;
   private double balance;
   private String status;

    @Override
    public String toString() {
        return "Accounts{" +
                "accountId=" + accountId +
                ", accountNumber='" + accountNumber + '\'' +
                ", name='" + name + '\'' +
                ", pincode='" + pincode + '\'' +
                ", balance=" + balance +
                ", status='" + status + '\'' +
                '}';
    }


    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}