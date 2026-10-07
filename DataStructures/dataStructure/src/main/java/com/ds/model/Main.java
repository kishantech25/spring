package com.ds.model;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        ProductDao dao =new ProductDao();

        List<Product> list=dao.getAllProducts();

        list.forEach(System.out::println);
    }
}
