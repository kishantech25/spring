package com.ds.annotation;

import com.ds.annotation.model.Employees;
import com.ds.annotation.service.EmployeeService;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamAPIDemo {

    public static void main(String[] args) {

        List<Integer> numbers =List.of(10,20,30,40,50,60,70);

        numbers.stream().filter(n->n>50).map(n->n*2);

        //added the terminal operations
        numbers.stream().filter(n->n>50).map(n->n*2).forEach(System.out::println);

        List<Integer> number1 =List.of(10,20,30,40,50,60);
        Spliterator<Integer> spliterator = number1.parallelStream().spliterator();

        List<Integer> num11 =List.of(10,20,30,40,509);

        int result = num11.stream().filter(n->n>50).findFirst().orElse(-1);

        //convert the employes.json data into Object
        EmployeeService service = new EmployeeService();
        ;
        List<Employees> employees =service.getEmployees();

//        List<Employees> results =new ArrayList<>();
//           //With out Stream API
//        for(Employees e:employees){
//            if(e.isActive()){
//                if(e.salary()>10000){
//                  results.add(e);
//                }
//            }
//        }
//        results.sort((e1,e2)->Integer.compare(e1.salary(),e2.salary()));
//        List<String> names=new ArrayList<>();
//
//        for(Employees e:results){
//            names.add(e.firstName()+" "+e.lastName());
//        }
//
        List<String> names =employees.stream()
                .filter(Employees::isActive)
                .filter(e->e.salary()>140000)
                .sorted(Comparator.comparing(Employees::salary))
                .map(Employees::firstName)
                .toList();

        List<Integer> numbers1 =
                List.of(1,2,3,4,5,6,7,8);

        numbers1.stream().filter(n->n>5).map(n->n*2).forEach(System.out::println);


                numbers.stream()
                        .filter(n -> {
                            System.out.println("filter " + n);
                            return n > 2;
                        })
                        .map(n -> {
                            System.out.println("map " + n);
                            return n * 10;
                        })
                        .toList();

                int num= numbers1.stream().filter(n->n>4)
                        .findFirst()
                        .orElse(-1);
                System.out.println(num);


          //short circuiting Behaviour
//        findFirst()
       Optional<String> firstName = employees.stream()
                .filter(e -> e.salary() > 10000).map(Employees::firstName)
                .findFirst();
       System.out.println(firstName);




//        findAny()





//        anyMatch()
//        allMatch()
//        noneMatch()
//        limit()

    //core
        //filter
        //map
        //flatMap
        //mapToInt
        //mapToLong
        //mapToDouble

    //Ordering /state
        //sorted
        //distinct
        //limit
        //skip
        //takeWhile
        //dropWhile

     //Matching
     //  anyMatch
        //allMatch
        //noneMatch


        //Finding

        //anyMatch
        //allMatch
        //noneMatch


        //Reduction
        //reduce
        //collect

        //Collectors
        //toList
        //toSet
        //toMap
        //groupingBy
        //partitioningBy
        //mapping
        //joining
        //summarizing
        //reducing
   // then
        /*
       Parallel Streams
       ↓
        Spliterator
       ↓
        ForkJoinPool
       ↓
        ForkJoinTask
       ↓
        Pipeline evaluation
       ↓
        Combiner
      */

//    int totalSalary =employees.stream().map(Employees::salary)
//            .reduce(0,(a,b)->a+b);
//
//    //without identity
//        Optional<Integer> ttlSalry =employees.stream().map(Employees::salary)
//            .reduce((Integer::sum));
//    System.out.println(ttlSalry);
//
//    List<String> employeLastName=employees.stream()
//            .map(Employees::lastName)
//            .collect(Collectors.toList());
//   Optional<String> nA= employeLastName.stream().reduce((s1,s2)->s1+" : "+s2);
//
//   System.out.println(nA);
//
//
//        Collector<Integer,List<Integer>,List<Integer>> collector =Collector.of(
//                ArrayList::new,
//                List::add,
//                (list1,list2)->{
//                    list1.addAll(list2);
//                    return list1;
//                }
//        );
//        List<Integer> result =
//                numbers.stream()
//                        .collect(collector);
//
//
//        List<Integer> numbers12 =
//                List.of(1, 2, 3, 4, 5, 6);
//
//        Collector<Integer,List<Integer>,List<Integer>> collector
//                =Collector.of(
//                 ArrayList::new,
//                List::add,
//                (l1,l2)->{
//                     l1.addAll(l2);
//                     return l1;
//                }
//        );

    }
}
