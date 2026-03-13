package com.microservice.Order_service.service.impl;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.microservice.Order_service.dto.OrderResponseDto;
import com.microservice.Order_service.dto.ProductResponseDto;
import com.microservice.Order_service.entity.Order;
import com.microservice.Order_service.repository.OrderReproistory;
import com.microservice.Order_service.service.OrderInterface;

import reactor.core.publisher.Mono;


@Service
public class OrderImpl implements OrderInterface {


    private OrderReproistory orderReproistory;

    private WebClient.Builder webClientBuilder;

    public OrderImpl(OrderReproistory orderReproistory , WebClient.Builder webClientBuilder) {
        this.orderReproistory = orderReproistory;
        this.webClientBuilder = webClientBuilder;
    }


    // create  a method to place order
    @Override
    public Mono<ResponseEntity<OrderResponseDto>> placeOrder(Order order) {
        return webClientBuilder.build().get()
                .uri("http://localhost:8081/api/products/" + order.getProductId()) // fixed URL with /
                .retrieve()
                .bodyToMono(ProductResponseDto.class)
                .map(productDTO -> {
                    OrderResponseDto responseDto = new OrderResponseDto();

                    responseDto.setProductId(order.getProductId());
                    responseDto.setQuantity(order.getQuantity());
                    responseDto.setProductName(productDTO.getName());
                    responseDto.setProductPrice(productDTO.getPrice());
                    responseDto.setTotalPrice(order.getQuantity() * productDTO.getPrice());
    
                    orderReproistory.save(order);
                    responseDto.setOrderId(order.getId());
    
                    return ResponseEntity.ok(responseDto);
                });
    }
    

    @Override
    public List<Order> getAllOrders() {
        return orderReproistory.findAll();
    }

    @Override
    public Order getOrderById(Long id) {
        return orderReproistory.findById(id).get();
    }

    @Override
    public Order updateOrder(Long id, Order order) {
        return orderReproistory.findById(id).orElseThrow(()-> new RuntimeException("Order not found"));
    }

    @Override
    public void deleteOrder(Long id) {
        orderReproistory.deleteById(id);
    }

}
