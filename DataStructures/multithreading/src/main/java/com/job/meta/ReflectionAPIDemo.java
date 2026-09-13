package com.job.meta;

public class ReflectionAPIDemo {

    public static void main(String[] args) throws  Exception{

        String className="com.job.oop.Employee";

        Class<?> clazz =Class.forName(className);

        System.out.println(clazz.getName());
        System.out.println(clazz.getSuperclass());

        System.out.println("FIELDS");
        System.out.println("-----------------");

        for(var field : clazz.getDeclaredFields()){
            System.out.println(field);
        }


        System.out.println("-----------------");

        System.out.println("METHODS");
        System.out.println("-----------------");

        for(var method : clazz.getDeclaredMethods()){
            System.out.println(method);
        }
        System.out.println("-----------------");

        System.out.println("CONSTRUCTORS");
        System.out.println("-----------------");
        for(var method : clazz.getDeclaredConstructors()){
            System.out.println(method);
        }
        System.out.println("-----------------");

        System.out.println("INTERFACES");
        System.out.println("-----------------");
        for(var method : clazz.getInterfaces()){
            System.out.println(method);
        }

    }
}
