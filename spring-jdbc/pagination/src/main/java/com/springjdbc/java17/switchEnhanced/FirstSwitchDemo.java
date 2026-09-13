package com.springjdbc.java17.switchEnhanced;

public class FirstSwitchDemo {

    public static void main(String[] args) {
        beforejava17SwitchedStatements(4);
        java17EnhancedStatements(2);
        String welcome = formatter(10.0);
        System.out.println(welcome);
        System.out.println(classifyNumber(11));

    }
    public static void beforejava17SwitchedStatements(int number){
        String result;
        switch(number){
            case 1:
                result ="one";
                break;
            case 2:
                result = "two";
                break;
            case 3:
                result  ="three";
            default:
                result ="unknown";
                break;
        }
        System.out.println(result);

    }
    public static void java17EnhancedStatements(int number){

       String result=  switch (number){
            case 1 -> "one";
            case 2 -> "two";
            case 3 -> "three";
            default -> "unknown";
        };
       System.out.println(result);
    }
    public static  String formatter(Object obj){
        String result= switch (obj){
            case (Integer i) -> "Integer: "+i;
            case (String s) -> "String : "+ s;
            case (Double d) -> "Double: "+d;
            default -> "Unknown type";
        };
        return result;
    }
    static String classifyNumber(Number number){
        String result =switch (number){
            case Integer i -> i % 2 == 0 ? "Even Integer" : "Odd Integer";
            case Double d -> d > 0 ? "Postive Double" : "Non-Postive Double";
            default -> "Unknown Number";
        };
        return result;
    }


}
