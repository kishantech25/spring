package com.kishan.ecom.service;

import com.kishan.ecom.entity.Product;
import com.kishan.ecom.repository.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository=productRepository;
    }

    public List<Product> getAllProducts(){
      return  productRepository.findAll();
    }

    public Product productById(int id){
        Product product=productRepository.findById(id).orElse(new Product());
        return product;
    }

    public Product addProduct(Product product, MultipartFile image) throws IOException {
        product.setImageName(image.getOriginalFilename());
        product.setImageType(image.getContentType());
        product.setImageData(image.getBytes());

        return productRepository.save(product);
    }
}
