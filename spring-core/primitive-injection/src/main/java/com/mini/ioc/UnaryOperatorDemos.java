package com.mini.ioc;

import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class UnaryOperatorDemos {

    public static void main(String[] args) {
       UnaryOperator<Double> unryOperator=num->Math.sqrt(num);
        String apiUrl ="https://jsonplaceholder.typicode.com/users";

        String s1 = StreamApi.liveDate(apiUrl);
        JsonToPojo pojo =new JsonToPojo();
        Users user =null;
        List<Users> users = pojo.getUsers(s1);

       System.out.println(unryOperator.apply(16.0));

       //Without Unary
        Function<String,String> upperFun =s ->s.toUpperCase();
        //with unary
        UnaryOperator<String> upperUn=s->s.toUpperCase();

        UnaryOperator<String> reverse=s-> new StringBuilder(s)
                                       .reverse().toString();
        System.out.println(reverse.apply("nahsik"));
        //Static Method
        UnaryOperator<String> id=UnaryOperator.identity();
        System.out.println(id.apply("java".hashCode()+""));

    }
}

