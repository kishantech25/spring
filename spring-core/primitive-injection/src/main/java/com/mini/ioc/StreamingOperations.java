package com.mini.ioc;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamingOperations {

    public static void main(String[] args) {

        String apiUrl ="https://jsonplaceholder.typicode.com/users";

        String s1 = StreamApi.liveDate(apiUrl);

        JsonToPojo pojo =new JsonToPojo();
        List<Users> users = pojo.getUsers(s1);

        //print all user  data

        users.stream().forEach(System.out::println);
        System.out.println("================ print all user name =====================");
        //print all user name
        users.stream().map(user->user.getName()).forEach(s->System.out.println(s));

        System.out.println("================ print even number list =====================");
        List<Integer> numbers =Arrays.asList(5,7,4,9,1,3,3,2,1,9,0,10,41,20,32,11,25);
        List<Integer> evenNumber=numbers.stream().filter(n->n % 2==0)
                                             .collect(Collectors.toList());
        System.out.println(evenNumber);

        System.out.println("===========Find Maximum in List=============");

        int max=numbers.stream().max(Integer::compare).orElseThrow();
        System.out.println(max);

        System.out.println("=========== Sort a list ===========");

        //sortlist of that Integer number
       List<Integer> list= numbers.stream().sorted().collect(Collectors.toList());
       list.forEach(n->System.out.print(n+"  "));

       System.out.println("=============Count a list starting with A Character =================");

      List<String> startWithC= users.stream().map(user->user.getName())
               .filter(s->s.startsWith("C"))
               .collect(Collectors.toList());
      System.out.println(startWithC.stream().count());

      System.out.println("======= Find First Non-Repeated Character in each name of String==============");

      users.stream().map(user->user.getName())
              .filter(s->s.startsWith("C"));
        String name="Kishan";
      //convert that into char array
        Predicate<Character> logic=c->name.indexOf(c) == name.lastIndexOf(c);

      List<Character> characters=  name.chars().mapToObj(c->(char)c)
                .filter(logic)
                        .collect(Collectors.toList());
      //count character in char Array
         System.out.println(characters);

      //  Function<Character,Integer> keyMapper=null;
     //   Function<Character,Integer> valueMapper=null;
     //   characters.stream().collect(Collectors.toMap(keyMapper,valueMapper));
    }
}
