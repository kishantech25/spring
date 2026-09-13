package com.job;

public class operatorsANDEpressions {

    public static void main(String[] args) {

        double result = 10.0/3; //return double
        System.out.println(result); //return double

        //the % operator
        System.out.println(10%3);//1
        System.out.println(20 % 3); //0

        System.out.println(10.5 % 3); //1.5
        int a =20;
        int b =6;
        System.out.println(a+b);
        System.out.println(a-b);
        System.out.println(a*b);
        System.out.println(a/b);
        System.out.println(a%b);

        int x = 10+20;

        System.out.println(x);
        String name ="Kishan";
        System.out.println(name);

        //Relational Operators
        int myAge=35;
        System.out.println(myAge);//35
        System.out.println(myAge>18); //true
        System.out.println(myAge<18); //false
        System.out.println(myAge<=35);//true
        System.out.println(myAge>36);//false

        //Equality Operators
        int operand1=10;
        int operand2=20;
        System.out.println(operand1 == operand2);
        System.out.println(operand1 != operand2);

        //Logical Operators
        int age =25;
        boolean citizen =true;
         //both condition must be true
        boolean eligible=age>=18 && citizen;
        System.out.println(eligible);


        boolean bbbbb=false;
        boolean result1=bbbbb & check();
        System.out.println(result1);

        //Bitwise Operator |
        boolean abc=true;
        boolean result2 = abc | check();
        System.out.println(result2);
        //Bitwise Operator &
        int sideX =0;
        boolean result3 = false & (++sideX>0);
        System.out.println(sideX);
        System.out.println(result3);

        //Bitwise Operator & | ^
        int xorA=5;
        int xorB =3;
        System.out.println("AND:"+(xorA&xorB));//1
        System.out.println("OR: "+(xorA | xorB));//7
        System.out.println("XOR: "+(xorA^xorB));//6

        //Shift Operators <<,>> ,>>>
        //<< Left Shift
        int leftShitfX=5;
        //left shift of binary i digit
        System.out.println(leftShitfX<<1); //10
        //>>Right Shift of binary digit 1
        System.out.println(leftShitfX>>1); //2
        //>>>Unsigned Right Shift of binary digit 1
        System.out.println(leftShitfX>>>1); //2

    }
    static boolean check(){
        System.out.println("check called");
        return true;
    }

}
