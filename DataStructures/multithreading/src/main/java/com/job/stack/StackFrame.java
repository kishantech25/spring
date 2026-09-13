package com.job.stack;

import com.job.Main;

public class StackFrame {
    private static int count;

    static int methodA(int x) {
        int x1 = 100+x;
        System.out.println("methodA");
        return methodB(x1);
    }

    static int methodB(int x1) {
        int y = 200+x1;
        System.out.println("methodB");
       return methodC(y);
    }

    static int methodC(int y) {
        System.out.println("methodC");
        return 300+y;
    }

    public static void main(String[] args) {

//        System.out.println("main method");
//        int x = 10;
//        System.out.println("x = " + x);
//       int total= methodA(x);
//       System.out.println("total = " + total);
        methodD();
    }

    public static void methodD(){
        count++;
        System.out.println("methodD "+count);
        try{
            Thread.sleep(5);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        methodE();
    }
    public static void methodE(){
        count++;
        System.out.println("methodE "+count);
        try{
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        methodD();
    }
}
