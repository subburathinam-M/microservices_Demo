package com.microservice.Order_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.microservice.Order_service.entity.Order;

@Repository
public interface OrderReproistory extends JpaRepository<Order, Long> {

}
