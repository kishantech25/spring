package com.example;

import com.ecommerce.oops.BankAccount;
import com.ecommerce.oops.CurrentsAccount;
import com.ecommerce.oops.savingsAccount;

public class App {
    public static void main(String[] args) {

        BankAccount bankAccount = new savingsAccount("123456789", 1000.0, "John Doe");
        System.out.println("Initial Balance: " + bankAccount.getBalance());
        bankAccount.deposit(500.0);
        System.out.println("Balance after deposit: " + bankAccount.getBalance());
        bankAccount.withdraw(300.0);
        System.out.println("Balance after withdrawal: " + bankAccount.getBalance());


        //create the Current Object
        BankAccount currentAccount=new CurrentsAccount("987654321", 2000.0, "Jane Smith");
        System.out.println("Current balance: "+currentAccount.getBalance());

        currentAccount.deposit(500.0);
        System.out.println("Balance after deposit: "+currentAccount.getBalance());
        currentAccount.withdraw(300.0);
        System.out.println("Balance after withdrawal: "+currentAccount.getBalance());


    }
}
