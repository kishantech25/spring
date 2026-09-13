package com.springjdbc.java17.sealed;

public sealed class Account permits FixedDepositAccount, SavingsAccount,CurrentAccount {

    public void accountCreated(){
        System.out.println("Account created");
    }


}
