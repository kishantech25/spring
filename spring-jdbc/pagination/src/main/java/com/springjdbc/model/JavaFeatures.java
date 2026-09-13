package com.springjdbc.model;

import com.springjdbc.dao.AccountsDao;

import java.util.List;

public class JavaFeatures {

    public static void main(String[] args) {

        AccountsDao dao =new AccountsDao();
        Accounts account= dao.findAccountsByAccountHOlderName("AccountHolder_999999");

        //convert into upper case
          var s ="       ";
     // java 11 features
        System.out.println(s.isBlank());
        String s1 = "  Hello  ";
        System.out.println(s1.strip());
        System.out.println("*".repeat(1));
        System.out.println("*".repeat(3));
        System.out.println("*".repeat(5));
        System.out.println("*".repeat(7));
        String text ="java\nSpring\nMicroservice";
        text.lines().forEach(System.out::println);

        myMethod();

    }

    public static  void myMethod(){

        String day ="We";
        String time="";
        //Switch expression
        time = switch(day){
            case "Sat", "Sun" -> "6am";

            case "Wed" -> "8am";

            default -> "7am";
        };
        System.out.println(time);
    }
}
