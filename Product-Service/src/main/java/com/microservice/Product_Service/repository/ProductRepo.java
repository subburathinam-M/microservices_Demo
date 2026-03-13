package com.microservice.Product_Service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.Product_Service.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product,Long> {

}
