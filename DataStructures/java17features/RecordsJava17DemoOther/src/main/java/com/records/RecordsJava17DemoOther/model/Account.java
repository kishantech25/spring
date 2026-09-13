package com.records.RecordsJava17DemoOther.model;

import jakarta.persistence.*;

@Entity
@Table(name = "account")
public class Account {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name="account_id")
   private int accountId;
   @Column(name="account_number")
   private String accountNumber;
   @Column(name="name")
   private String name;
   @Column(name="pincode")
   private String pincode;
   @Column(name="balance")
   private double balance;
   @Column(name = "Status")
   private String status;

   public Account(){
   }
   public Account(String accountNumber, String name, String pincode, double balance, String status) {
      this.accountNumber = accountNumber;
      this.name = name;
      this.pincode = pincode;
      this.balance = balance;
      this.status = status;
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

