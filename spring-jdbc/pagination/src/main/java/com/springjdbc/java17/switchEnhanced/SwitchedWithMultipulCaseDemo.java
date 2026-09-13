package com.springjdbc.java17.switchEnhanced;

public class SwitchedWithMultipulCaseDemo {

    public static void main(String[] args) {
        beforejava17withMultipulCaseValue(3);
        java17withMultipulCaseValue(3);
    }

    public static void beforejava17withMultipulCaseValue(int number){
        switch(number){
               case 1:
                System.out.println("one");
                break;
                case 2:
                    case 3:
            case 4:
                System.out.println("two three or four");
                break;
            default:
                System.out.println("unknown");
                break;
        }
    }
    public static void java17withMultipulCaseValue(int number){
        String result = switch (number){
          case 1 -> ("one");
          case 2,3,4 -> ("two ,three,four");
          default -> ("unknown");
        };
       System.out.println(result);
    }
}
