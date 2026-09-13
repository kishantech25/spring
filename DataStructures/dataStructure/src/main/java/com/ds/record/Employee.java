package com.ds.record;

import java.io.Serializable;

//multiple Components with multiple Interfaces
public record Employee (int id,
                       String name,
                       double salary,
                       String department) implements Printable, Serializable,Comparable<Employee> {

//      public Employee{
//          if(id<=0){
//              throw new IllegalArgumentException();
//
//              name =name.toUpperCase();
//          }
//      }
      //canoncial Constructor
//      public Employee(int id,String name){
//          this.id=id;
//          this.name=name;
//      }
      //Static Field
    static String company="OpenAI";
      //Static Method
    static void printCompany(){
        System.out.println("ABC");
    }
    //Instance Method
    public double employeSalaryYerly(){
        return salary*12;
    }
    @Override
    public void print() {
        System.out.println("Name is"+name+" Salary : "+salary+"Department: "+department);
    }


    @Override
    public int compareTo(Employee s) {
        return Integer.compare(id,s.id);
    }

    @Override
    public String toString() {
        return "Employee";
    }

//    @Override
//    public boolean equals(Employee obj) {
//
//        if(this.name().equals(obj.name())){
//            return true;
//        }
//        return false;
//    }
}
