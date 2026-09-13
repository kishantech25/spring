package com.springjdbc.java17.patternMatching;

public class PatternMatchingDemoForInstanceOf {

    public static void main(String[] args) {

        Object obj ="Hello World";
      //before 17
        if(obj instanceof  String){
            String str =(String) obj;
            System.out.println(str.length());
        }
        if(obj instanceof String str){
            System.out.println(str.length());
        }


    }


}
