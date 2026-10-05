package com.corejava.fundamental.stream;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FindEvenNumbers {

    public List<Integer> findEvenNumber(List<Integer> numbers){
        return numbers.stream().filter(n->n%2==0).collect(Collectors.toList());
    }
    //Find Maximimn Value in the list
   public Optional<Integer> findMaximumValue(List<Integer> numbers){
       return  numbers.stream().max(Integer::compareTo);
   }
   //Sum Of Eleemnets
    public int sumOfElement(List<Integer> list){
        return list.stream().mapToInt(Integer::intValue)
                             .sum();
    }
//    public List<Integer> listofNamesUppercase(List<String> names){
//        return names.stream().map(name->name.toUpperCase());
//
//    }
    public List<Integer> sortedList(List<Integer> list){
        return list.stream().sorted()
                .collect(Collectors.toList());
    }

//    public int countElements(List<Integer> elemenets){
//      return elemenets.stream().filter(n->n>100).count();
//    }

    //Get Distinct Elements
    public List<Integer> getDistinctElement(List<Integer> numbers){
       return  numbers.stream().distinct().collect(Collectors.toList());
    }

    //Reduce to sum
    public int reduceSum(List<Integer> numbers){
        return numbers.stream().reduce(0,Integer::sum);
    }

    public Optional<Integer> reurnElement(List<Integer> numbers){
        return numbers.stream().findAny();
    }




}
