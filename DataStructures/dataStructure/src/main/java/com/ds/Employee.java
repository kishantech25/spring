package com.ds;

public record Employee(int id,
                       String name,double salary,String department) implements  Printable{


    public Employee{
        if(id<=0){
            throw new IllegalArgumentException();
        }
        name=name.toUpperCase();
    }

    static String company="Google";

    public double tax(String name){
        System.out.println(" Employee "+name+" has paid the Tax 1000");
        return 10.5;
    }

    @Override
    public void print() {
        System.out.println(id+" : "+name+" : "+company);
    }

}
