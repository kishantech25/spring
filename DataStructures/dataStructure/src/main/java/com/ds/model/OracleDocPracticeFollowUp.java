package com.ds.model;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OracleDocPracticeFollowUp {

    public static void main(String[] args) {
         List<Product> products =new ProductDao().getAllProducts();
        //Accuulate name into list
//        List<String> list =new ProductDao().getAllProducts().stream().map(Product::getProductName)
//                .collect(Collectors.toList());

        //Accumulate names into a TreeSet

//        Set<String> set =products.stream()
//                .map(Product::getBrand)
//                .collect(Collectors.toCollection(TreeSet::new));

        //convert elements to String and concatenate them,s Seperated by commas
        String joined  = products.stream().map(Product::getBrand)
                .map(Object::toString)
                .collect(Collectors.joining(","));

        System.out.println(joined);

        //compute sum of Product of  all product

        double total =products.stream().collect(Collectors.summingDouble(Product::getPrice));
        System.out.println("Total Amount calculated of Produtcs: "+total);

        //Group Products by Category
        Map<String,List<Product>> byCategory=products.stream().collect(Collectors.groupingBy(Product::getCategory));

      //  byCategory.entrySet().stream().forEach(entry->System.out.println(entry.getKey()+"::"+entry.getValue()));

        //compute sum of category Price
        Map<String,Double> totalByBrand=products.stream().collect(Collectors.groupingBy(Product::getBrand,Collectors.summingDouble(Product::getPrice)));

            //Group Product by Category
        Map<String,List<Product>> groupProductByCategory =products.stream()
                .collect(Collectors.groupingBy(Product::getCategory));
        groupProductByCategory.entrySet().stream().forEach(entry->System.out.println(entry.getKey()+" ::::: "+entry.getValue()));


        //Compute Some price by brand like brandName: 464647

     //   Map<String,Double> eachBrandWorth=products.stream().collect(Collectors.groupingBy(Product::getBrand,Collectors.summingDouble(Product::getPrice)));

       // eachBrandWorth.entrySet().forEach(entry->System.out.println(entry.getKey()+" :::::::::::::::::"+entry.getValue()));

        // Partition students into passing and failing

//        Map<Boolean,Double> partitionByRating = products.stream().collect(Collectors.partitioningBy(product -> product.getRating()>4.5));
//
//        partitionByRating.entrySet().stream().forEach(entry->entry.getKey()+" ::: "+entry.getValue());





    }

}
