package com.ds.productRepository;

import com.ds.record.Product;

import java.util.Arrays;
import java.util.List;

public class ProductRespository {

    public List<Product> getProductRepository(){
        List<Product> products = Arrays.asList(
                new Product(1,1000,true),
                new Product(2,1050,true),
                new Product(3,1100,false),
                new Product(4,1200,true),
                new Product(5,1300,false),
                new Product(6,1400,true),
                new Product(7,1800,false),
                new Product(8,1700,true),
                new Product(9,1800,false),
                new Product(10,2200,true),
                new Product(11,1200,false),
                new Product(12,4300,true),
                new Product(13,2500,false),
                new Product(14,3000,true),
                new Product(15,4000,false),
                new Product(16,3000,true),
                new Product(17,2000,false),
                new Product(18,2200,true)
        );
        return products;
    }
}
