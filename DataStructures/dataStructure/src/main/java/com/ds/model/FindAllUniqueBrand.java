package com.ds.model;

import java.util.*;
import java.util.stream.Collectors;

public class FindAllUniqueBrand {

    public Set<String> findAllUniqueBrand(List<Product> products){

        return products.stream().map(Product::getBrand).collect(Collectors.toSet());
    }
    public Set<String> findAlluniqueBrandGreaterThanRating(List<Product> products){
         return products.stream().filter(p->p.getRating()>4.5).map(Product::getBrand).collect(Collectors.toSet());
    }

    public String getAllProductName(List<Product> products){

       String productNames= products.stream().map(Product::getProductName).collect(Collectors.joining());
       return productNames;
    }
    public String getAllActiveProductName(List<Product> products){
        return products.stream().filter(product -> product.getStatus().equalsIgnoreCase("Active"))
                .map(Product::getProductName)
                .collect(Collectors.joining());
    }

    public Map<String,Long> findTotalNumberOfProductBelongsToEachCategory(List<Product> products){
//        Map<String,Long> map =new HashMap<>();
//        long count=0l;
//          //Without stream api
//        for(Product product:products){
//            String category=product.getCategory();
//            if(products.contains(category)){
//                     count++;
//            }
//        }
         Map<String,Long> category=products.stream().collect(Collectors.groupingBy(Product::getCategory,Collectors.counting()));
        return category;
    }

//    public Map<String,List<Product>> groupProductByCategory(List<Product> products){
//
//          Map<String,List<Product>> productByCategory
//                    =products.stream().collect(Collectors.groupingBy(Product::getCategory, ArrayList::new,p))
//    }




    public static void main(String[] args) {
        FindAllUniqueBrand brands =new FindAllUniqueBrand();
       Set<String> uniqueBrands= brands.findAllUniqueBrand(new ProductDao().getAllProducts());
       Set<String> findAlluniqueBrandGreaterThanRating=brands.findAlluniqueBrandGreaterThanRating(new ProductDao().getAllProducts());
       String allProductName= brands.getAllProductName(new ProductDao().getAllProducts());
       String allActiveProductName =brands.getAllActiveProductName(new ProductDao().getAllProducts());

       Map<String,Long> category=brands.findTotalNumberOfProductBelongsToEachCategory(new ProductDao().getAllProducts());
       category.entrySet().stream().forEach(entry->System.out.println(entry.getKey()+": :"+entry.getValue()));


       //find total number Of products belongsing to each category

     //  System.out.println(allProductName);
     //   System.out.println(allActiveProductName);

      // uniqueBrands.forEach(System.out::println);
      //  findAlluniqueBrandGreaterThanRating.forEach(System.out::println);


    }

}
