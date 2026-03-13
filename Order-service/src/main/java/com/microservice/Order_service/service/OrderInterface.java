package com.microservice.Order_service.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.microservice.Order_service.dto.OrderResponseDto;
import com.microservice.Order_service.entity.Order;

import reactor.core.publisher.Mono;

public interface OrderInterface {

    Mono<ResponseEntity<OrderResponseDto>> placeOrder(Order order);
    List<Order> getAllOrders();
    Order getOrderById(Long id);
    Order updateOrder(Long id, Order order);
    void deleteOrder(Long id);
   

}
