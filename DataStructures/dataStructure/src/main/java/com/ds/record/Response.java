package com.ds.record;

import java.util.List;

//Generic record
public record Response(int data,String message) {
}

//for example
//Response<Employee>
//Response<List<Employee>>
//Response<Product>
