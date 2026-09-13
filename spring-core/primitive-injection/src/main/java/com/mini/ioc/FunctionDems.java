package com.mini.ioc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionDems {


    public static void main(String[] args) {

        String apiUrl ="https://jsonplaceholder.typicode.com/users";

        String s1 = StreamApi.liveDate(apiUrl);
        JsonToPojo pojo =new JsonToPojo();
        Users user =null;
        List<Users> users = pojo.getUsers(s1);
        FunctionDems demo=new FunctionDems();
        Function<String,Integer> keyMapper =(u)->demo.getUsersIdByUserName(u);
        Function<String,Users> keyValue=(u)->demo.getUsersByUserName(u);
        toMap(keyMapper.apply("Clementine Bauch"),keyValue.apply("Clementine Bauch")).forEach((k,v)->System.out.println("Key: "+k+"  Value: "+v));
    }

    public static Map<Integer,Users> toMap(Integer key,Users value){

        Map<Integer,Users> map =new HashMap<>();
        map.put(key,value);
        return map;
    }




    public Integer getUsersIdByUserName(String userName) {

        String apiUrl = "https://jsonplaceholder.typicode.com/users";

        String json = StreamApi.liveDate(apiUrl);

        JsonToPojo pojo = new JsonToPojo();

        List<Users> users = pojo.getUsers(json);

        if (users == null || users.isEmpty()) {
            return null;
        }

        for (int i = 0; i < users.size(); i++) {

            if (users.get(i).getName().equalsIgnoreCase(userName)) {
                return users.get(i).getId();
            }
        }

        return null;
    }
    public Users getUsersByUserName(String userName) {

        String apiUrl = "https://jsonplaceholder.typicode.com/users";

        String json = StreamApi.liveDate(apiUrl);

        JsonToPojo pojo = new JsonToPojo();

        List<Users> users = pojo.getUsers(json);

        if (users == null || users.isEmpty()) {
            return null;
        }

        for (int i = 0; i < users.size(); i++) {

            if (users.get(i).getName().equalsIgnoreCase(userName)) {
                return users.get(i);
            }
        }

        return null;
    }

}
