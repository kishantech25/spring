package com.mini.ioc;

import java.util.List;
import java.util.function.Supplier;

public class SupplierDemos {

    static Supplier<List<Users>> supplier=()->{
            String apiUrl ="https://jsonplaceholder.typicode.com/users";

            String s1 = StreamApi.liveDate(apiUrl);
            JsonToPojo pojo =new JsonToPojo();
            Users user =null;
            List<Users> users = pojo.getUsers(s1);
            return users;
        };

    public static void main(String[] args) {

         List<Users> users=supplier.get();

        users.stream().forEach(System.out::println);
    }
}
