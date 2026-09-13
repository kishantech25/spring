package com.mini.ioc;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMapDemo {

    public static void main(String[] args) {

        String apiUrl ="https://jsonplaceholder.typicode.com/users";

        String s1 = StreamApi.liveDate(apiUrl);

        JsonToPojo pojo =new JsonToPojo();
        List<Users> users = pojo.getUsers(s1);

        //get List of users Name
        List<String> userNames =users.stream().map(s->s.getName()).collect(Collectors.toList());

        userNames.forEach(System.out::println);
        //Length of each String
        System.out.println("===============length of each name===================");
        List<Integer> usernameLength =userNames.stream().map(s->s.length()).collect(Collectors.toList());
        usernameLength.forEach(value->System.out.print(value+" "));

        List<List<String>> list =Arrays.asList(
                Arrays.asList("A","B"),
                Arrays.asList("C","D"),
                Arrays.asList("E","F"));
        //lets try on map
         System.out.println(list);
        System.out.println();

        list.stream().map(x->x).forEach(System.out::print);
        System.out.println();
        //use Flat map
        list.stream().flatMap(List::stream).forEach(System.out::print);

        List<String> words =Arrays.asList("JAVA","STREAM");

        System.out.print(words);

     // List<Character> wordList=  words.stream().map(word->word.split("")).flatMap(Arrays::stream);

     }
}
