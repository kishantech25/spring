package com.ds.streamApi;

import com.ds.productRepository.ProductRespository;
import com.ds.record.Product;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamApiDemo {

    public static void main(String[] args) {

        List<Integer> numbers = Arrays.asList(10,20,15,30,5);

        System.out.println(getDistinct());
        System.out.println(sortedTest());
        compareingProductRate();


        // Traditional Approach
//         for(Integer n : numbers){
//             if(n > 10){
//                 System.out.println(n * 2);
//             }
//         }

         //Stream Api approach

        numbers.stream().filter(n->n>10)
                .map(n->n * 2)
                .forEach(System.out::println);

        getNames().forEach(System.out::println);
    }

    public static List<String> getNames(){
        List<String> names =Arrays.asList(
            "Kishan",
            "Rahul",
            "Amit",
            "Kumar"
        );

        List<String> result =names.stream().filter(name->name.startsWith("K"))
                .map(String::toUpperCase)
                .collect(Collectors.toList());
          return result;
    }

    public static List<Integer> getDistinct(){
        List<Integer> numbers =Arrays.asList(1,2,2,3,3,3,4,5,6,5);

        //Remove the duplicates
        return numbers.stream().distinct().collect(Collectors.toList());
    }
    public static List<Integer> sortedTest(){
        List<Integer> numbers = Arrays.asList(1,1,1,2,2,3,3,3,5,6,7,8);
        return numbers.stream().sorted()
                .collect(Collectors.toList());
    }
    public static void compareingProductRate(){
        List<Product> products =new ProductRespository().getProductRepository();

//       List<Integer> pricess= products.stream().sorted(Comparator.comparing(Product::price))
//                                           .collect(Collectors.toList());

       //pricess.forEach(System.out::println);

    }

}
