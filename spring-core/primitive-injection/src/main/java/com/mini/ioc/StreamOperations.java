package com.mini.ioc;

import java.io.StringReader;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamOperations {

    public static void main(String[] args) {
        String apiUrl ="https://jsonplaceholder.typicode.com/users";

        String s1 = StreamApi.liveDate(apiUrl);

        JsonToPojo pojo =new JsonToPojo();
        List<Users> users = pojo.getUsers(s1);

        //print all users names
        System.out.println("===============print all users names================");
        users.stream().map(u->u.getName())
                .forEach(System.out::println);

         //print All email IDs
        System.out.println("===============print All email IDs==================");
        users.stream().map(u->u.getEmail())
                .forEach(System.out::println);
        //Print users whose ID is greater than 5.
        System.out.println("==================Print users whose ID is greater than 5======================");

       List<Users> greaterIdBy5Users=  users.stream().filter(user->user.getId()>5)
                        .collect(Collectors.toList());
        greaterIdBy5Users.forEach(System.out::println);

        System.out.println("=================Count the total no of users==================");
        System.out.print("Total number of users :: "+users.stream().count());

        System.out.println("==============Find the first user");

        String s =users.stream().map(u->u.getName()).findFirst().orElseThrow();
        System.out.println("First Name is :: "+s);

        System.out.println("==============Find the any user====================");

        String anyUser =users.stream().map(u->u.getName()).findAny().orElseThrow();
         System.out.println("Any User :: "+anyUser);

        //Check whether any user belongs to city "Gwenborough"
        System.out.println("==============Check whether any user belongs to city Gwenborough================");
        Predicate<String> c=city->city.equals("Gwenborough");
       List<Users> list= users.stream().filter(u->u.getAddress().getCity().equals("Gwenborough")).toList();

        list.stream().forEach(System.out::println);
        //Check whether no user belongs to city "Delhi".
        System.out.println("===========Check whether no user belongs to city Delhi==========================");

        //9. Find duplicate User name in a List

        System.out.println("=====================Find duplicate User name in a List=========================");

        List<String> usersList= users.stream().map(user->user.getName()).collect(Collectors.toList());
        //   usersList.forEach(System.out::println);
       Set<String> unique =new HashSet<>();
//        public Set<String>  uniqueElement(String str){
//            Set<String> unique =new HashSet<>();
//            if(!unique.contains(str)){
//                unique.add(str);
//            }
//            return unique;
//        }
        Predicate<String> predicate =(String str)->!unique.add(str);
        Set<String> duplicats=usersList.stream().filter(predicate)
                .collect((Collectors.toSet()));
        duplicats.forEach(System.out::println);
//         for(int i=0;i<usersList.size()-1;i++){
//              if(usersList.get(i) == usersList.get(i+1)){
//                  System.out.println("Duplicate User name is::"+usersList.get(i));
//              }
//         }
        //10 Group Srings by Length

        System.out.println("============ Group Srings by Length ============");

    //    Map<Integer,List<String>> groupedByLength =usersList.stream().collect(Collectors.groupingBy(s->s.length()));
     //   System.out.println(groupedByLength);
        //without Stream API

        groupedByLength(usersList);
        //11 Flatten a User List of Lists
        System.out.println("============ Flatten a User List of Lists ============");

     //   List<Map<String,Object>> flattenList =users.stream().flatMap(StreamOperations::flatternUser)
        //print the Map Object
    //     System.out.println(flattenList);

        //12 Concatenate Strings
        //13  Find the Lomngest String
        //14 Count Frequencey of Characters in a String
        //15 Parallel Stream to Compute SUM
        //16 Create Custom Collector
        //17 Remove Null Values
        //18 Calculate Average of Numbers
        // 19 Collect Map from List
        // 20 Partition Numbers into Even and Odd
        // 21 Find Nth Largest Element in a List
        // 22 Find All Palindromic Strings
        //23 Reverse Each String in List
        //24 Filter and Convert Map to List
        //25 Remove Duplicares Without Collectors
        //26 Find Most Frequestnt Character in
        //27 Find Common Elements between two List
        //28 Find Sum of Squars of Even numbes
        //29 Partition String by palidrome
        // 30 Find the Longest Word in Sentence
        // 50 Find All Subsequences of a String
        //51 Count Frequencey of Characters in a String
        //52 Flattern a Nested List
        //53 Find a duplicates Elements in a List
        //54 Convert Map to List of Key-Value Pairs
        //55 Check if a List is sorted
        //56 Find All SubArrays of List
        //57 Combine Two List into a Map
        //58 Find Pair of  Numbers with a Given Sum
        //59 Find Longesr Increasing SubSequence
        //60 Sort a List Based on Frequency of Elements

    }
    public static Map<Integer,List<String>> groupedByLength(List<String> words){

        Map<Integer,List<String>> map =new HashMap<>();

        for(String str : words){
            int key =str.length();
            if(!map.containsKey(key)){
                map.put(key,new ArrayList<>());
            }
            map.get(key).add(str);
        }
        System.out.println(map);
        return map;
    }

    public static Map<String,Object> flatternUser(Users user){

        Map<String,Object> map = new LinkedHashMap<>();

        map.put("id", user.getId());
        map.put("name", user.getName());
        map.put("username", user.getUsername());
        map.put("email", user.getEmail());

        Address address = user.getAddress();

        map.put("street", address.getStreet());
        map.put("suite", address.getSuite());
        map.put("city", address.getCity());
        map.put("zipcode", address.getZipcode());

        Geo geo = address.getGeo();

        map.put("lat", geo.getLat());
        map.put("lng", geo.getLng());

        map.put("phone", user.getPhone());
        map.put("website", user.getWebsite());

        Company company = user.getCompany();

        map.put("companyName", company.getName());
        map.put("catchPhrase", company.getCatchPhrase());
        map.put("bs", company.getBs());

        return map;

    }


}
