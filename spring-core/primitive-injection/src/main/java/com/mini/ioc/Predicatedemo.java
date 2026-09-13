package com.mini.ioc;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Predicatedemo {

    public static void main(String[] args) {

        String apiUrl ="https://jsonplaceholder.typicode.com/users";

        String s1 = StreamApi.liveDate(apiUrl);

        JsonToPojo pojo =new JsonToPojo();
        List<Users> users = pojo.getUsers(s1);
        //Preidcats familt uses
        Predicate<Integer> isEven =n -> n%2 ==0;
        Predicate<Integer> isAdult =age->age>18;
        Predicate<Integer> result =isEven.and(isAdult);
        Predicate<String> isEmpty = s->s.isEmpty();
        Predicate<Double> salaryGreater =sal->sal >50000;
        Predicate<Users> startsWithC= u->u.getName().startsWith("C");



        System.out.println(isEven.test(11));
        System.out.println(isAdult.test(11));
        System.out.println(result.test(20));
        System.out.println(isEmpty.test(" "));
        System.out.println(salaryGreater.test(500001.0));

        //get list uses in Stream Api ,users starts with c
        List<String> getListStartWithC=users.stream().map(user->user.getName())
                .filter(name->name.startsWith("C")).collect(Collectors.toUnmodifiableList());
             getListStartWithC.forEach(s->System.out.println(s+" "));
    }

    @FunctionalInterface
    interface  Predicates<T>{
        boolean test(T t);
    }

}
