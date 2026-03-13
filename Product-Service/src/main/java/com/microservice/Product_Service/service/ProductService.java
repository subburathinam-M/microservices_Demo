package com.microservice.Product_Service.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.microservice.Product_Service.entity.Product;

public interface ProductService {

    Product addProduct(Product product);
    List<Product> getAllProducts();
    ResponseEntity<Product> getProductById(Long id);
    Product updateProduct(Long id, Product product);
    void deleteProduct(Long id);

}
