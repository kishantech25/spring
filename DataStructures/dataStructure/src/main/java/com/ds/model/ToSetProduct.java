package com.ds.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class ToSetProduct {

    public static void main(String[] args) {

        List<Product> products =new ProductDao().getAllProducts();

        List<String> sortedProductByBrand =products.stream().map(Product::getBrand).sorted()
                                                            .collect(Collectors.toCollection(LinkedList::new));

      //  products.stream().forEach(System.out::println);

        //convert the List into set
        Set<String> set = products.stream().map(Product::getBrand).collect(Collectors.toSet());

       // System.out.println(set.getClass().getName());

       //Sort the product by product Brand

         Set<String> sortByBrand = products.stream().map(Product::getBrand)
                                                   .collect(Collectors.toCollection(TreeSet::new));
         sortByBrand.forEach(System.out::println);

         System.out.println(sortByBrand.getClass().getName());

    }
}
