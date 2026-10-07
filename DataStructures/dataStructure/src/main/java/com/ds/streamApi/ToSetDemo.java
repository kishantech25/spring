package com.ds.streamApi;

import com.ds.model.Product;
import com.ds.model.ProductDao;

import java.util.List;
import java.util.stream.Collectors;

public class ToSetDemo {

    public static void main(String[] args) {

        List<Product> allProducts =new ProductDao().getAllProducts();

        //map the List into Set

        List<String> set = allProducts.stream().map(Product::getBrand)
                                              .collect(Collectors.toList());
        set.forEach(System.out::println);
    }
}
