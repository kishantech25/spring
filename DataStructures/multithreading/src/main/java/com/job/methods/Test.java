package com.job.methods;

import java.util.HashMap;
import java.util.Map;

public class Test {
    int x =10;
    static int y =20;

    public static void main(String[] args) {
        staticMethod2();
    }
    void instanceMethod(){
        System.out.println(x);
        System.out.println(y);
    }
    static void staticMethod(){

        Map<String,Object> map = new HashMap<>();
        map.put("x",100);
        map.put("y",20);
        map.put("z",300);
        System.out.println(map);
        System.out.println(y);
        //System.out.println(x); // This would cause a compile-time error
    }
    static void staticMethod2(){
        int x=100;
        //static int y=200;
        System.out.println(x);
       // System.out.println(y);
    }


}
