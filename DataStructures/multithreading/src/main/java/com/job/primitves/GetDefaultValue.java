package com.job.primitves;

public class GetDefaultValue {   int a;
    double b;
    boolean c;
    char c1;
    String s;

    static
    {
        GetDefaultValue g = new GetDefaultValue();

//        System.out.println(g.b);
//        System.out.println(g.c);
//        System.out.println(g.s);
//        System.out.println(g.c1);
//        g.calculate();
//        g.test();


    }

    public static void main(String[] args) {

        Thread t1 = new Thread(()->{
            Employee e1 = new Employee();
            e1.work();
        });
        Thread t2 =new  Thread(()->{
            Employee e2 = new Employee();
            e2.work();
        });

        t1.start();
        t2.start();
    }

    public void calculate(){
        int x =10;
        int y =20;

        int result= x + y;
      System.out.println(result);
    }
    public void test(){
        int x =10;
        if (x > 5){
            int y = 20;
            System.out.println(y);
        }
    }


}
class Employee{
    static String name="ABC";
    String company;

    void work(){
        int hours= 12;

        System.out.println("static Variable "+name);
        System.out.println("non-static Variable "+company);
        System.out.println("local Variable "+hours);

        try{
            int x =10/0;
        }
        catch(ArithmeticException e){
            e.printStackTrace();
        }
    }
}
