package com.kishan.ecom.controller;

import com.kishan.ecom.entity.Product;
import com.kishan.ecom.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:5173/")
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts(){
        return  new ResponseEntity<>(productService.getAllProducts(), HttpStatus.ACCEPTED);
    }
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id){
          Product product =productService.productById(id);
          if(product.getId()>0)
              return new ResponseEntity<>(product,HttpStatus.OK);
          else
             return new ResponseEntity<>(productService.productById(id),HttpStatus.NOT_FOUND);
    }

    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestPart Product product, @RequestPart MultipartFile image) throws IOException{
        Product savedProduct=null;
        try{
            savedProduct= productService.addProduct(product,image);
            return new ResponseEntity<>(savedProduct,HttpStatus.CREATED);
        }
        catch (IOException ex) {
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("product/{productId}/image")
    public ResponseEntity<byte[]> getIMageByProductId(@PathVariable int productId){
         Product product= productService.productById(productId);
         return new ResponseEntity<>(product.getImageData(),HttpStatus.OK);
    }

}
