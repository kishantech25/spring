package com.ecommerce.oops;

public class savingsAccount extends BankAccount{
    public savingsAccount(String accountNo, double balance, String holderName) {
        super(accountNo, balance, holderName);
    }

    @Override
    public void withdraw(double amount) {
        if(getBalance() >= amount){
            setBalance(getBalance() - amount);
        }
    }


}
