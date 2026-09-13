package com.job.methods;

public class Person {
    int age;

    static void change(Person p){
        p=new Person();
        p.age=100;
    }

    public static void main(String[] args) {

        Person person = new Person();
        person.age=20;
        change(person);
        System.out.println(person.age);//20
        person.walk();
    }
    static void change(int x){
        x=100;
    }

    //instance method
    void walk(){
        System.out.println("walking....");
    }

    //primitive vs object reference


//    static void change(Person p){
//        p.age =100;
//
//    }
}
