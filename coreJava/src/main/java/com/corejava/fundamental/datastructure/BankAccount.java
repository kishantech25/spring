package com.corejava.fundamental.datastructure;

public class BankAccount {
    int accountNumber;
    double balance;
    String accountHolderName;

    // Method that computes a value from internal state and parameters
    double calculateProjectedInterest(double annualRate) {
        return balance * (annualRate / 100.0);
    }

    // Method that mutates internal state
    void deposit(double amount) {
        if (amount <= 0) {
            return;
        }
        balance += amount;
    }
}
