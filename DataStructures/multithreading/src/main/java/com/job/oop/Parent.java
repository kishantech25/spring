package com.job.oop;
public class Parent {

    int x = 10;

    void show() {
        System.out.println("Parent");
    }
}

class Child extends Parent {

    int x = 20;

    void test() {

        System.out.println(x);        // 20
        System.out.println(super.x);  // 10

        show();        // Parent.show()
        super.show();  // Parent.show()
    }
}
