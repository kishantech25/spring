package com.ecommerce.oops;

public class CurrentsAccount extends BankAccount{

    public CurrentsAccount(String accountNo, double balance, String holderName) {
        super(accountNo, balance, holderName);
    }
    @Override
    public void withdraw(double amount) {

    }
}
