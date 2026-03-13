package com.microservice.Product_Service.service.Impl;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.microservice.Product_Service.entity.Product;
import com.microservice.Product_Service.repository.ProductRepo;
import com.microservice.Product_Service.service.ProductService;


@Service
public class ProductServiceImpl implements ProductService{

    private final ProductRepo productRepo;

    public ProductServiceImpl(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public Product addProduct(Product product) {
       return productRepo.save(product);
    }

    @Override
    public List<Product> getAllProducts() {
      return productRepo.findAll();
    }

    @Override
    public ResponseEntity<Product> getProductById(Long id) {
        Product product = productRepo.findById(id).orElseThrow(()-> new RuntimeException("Product not found"));
        return ResponseEntity.ok(product);
    }

    @Override
    public Product updateProduct( Long id, Product product) {
        Product Existing = productRepo.findById(id).orElseThrow(()-> new RuntimeException("Product not found"));
            Existing.setName(product.getName());
            Existing.setPrice(product.getPrice());
            return productRepo.save(Existing);
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = productRepo.findById(id).orElseThrow(()-> new RuntimeException("Product not found"));
        productRepo.delete(product);
    }

}
