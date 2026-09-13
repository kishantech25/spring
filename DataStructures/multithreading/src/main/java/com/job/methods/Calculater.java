package com.job.methods;

public class Calculater {

    public int add(int a,int b){
        return a+b;
    }

    public int add(int a,int b,int c){
        return a+b+c;
    }
    double add(double a,double b,double c){
        return a+b+c;
    }
    public static int adds(int a, int b) throws Exception {
        return a+b;
    }
    public void test(int i,String s){

    }
    public void test(String s,int i){

    }
    int test(){return 1;}
    public int square(int a){
        if(a>0){
            return a*a;
        }
        return 0;
    }

    void printHello(){
        System.out.println("Hello");
    }

    public static void main(String[] args) {

//        Calculater calculater = new Calculater();
//        try {
//            int added = Calculater.adds(1, 2);
//            System.out.println(added);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        int a =10;
//        a = change(a);
//        System.out.println(a);
//        System.out.println(calculater.add(1,2,3));


        int factorial = factorial(5);
        System.out.println(factorial);
    }
    static int factorial(int n) {

        if (n == 1) {
            return 1;
        }

        return n * factorial(n - 1);
    }
    static int sum(int x,int y){
        return x+y;
    }
    static int sum(int... numbers){
        int total =0;

        for(int n : numbers){
            total += n;
        }
        return total;
    }

    static int change(int x){
        x =100+x;
        return x;
    }



}
