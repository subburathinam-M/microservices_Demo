package com.microservice.Order_service.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.Order_service.dto.OrderResponseDto;
import com.microservice.Order_service.entity.Order;
import com.microservice.Order_service.service.OrderInterface;

import reactor.core.publisher.Mono;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("api/orders")
public class OrderController {

    private final OrderInterface orderInterface;

    public OrderController(OrderInterface orderInterface) {
        this.orderInterface = orderInterface;
    }


    @PostMapping
    public Mono<ResponseEntity<OrderResponseDto>> placeOrder(@RequestBody Order order) {
        return orderInterface.placeOrder(order);
    }
    
    @GetMapping
    public List<Order> getAllOrders() {
        return orderInterface.getAllOrders();
    }

    @GetMapping("/{id}")
    public Order getMethodName(@PathVariable Long id) {
        return orderInterface.getOrderById(id);
    }

    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable Long id,  @RequestBody Order order) {
        return orderInterface.updateOrder(id, order);
    }
    
    @DeleteMapping
    public String deleteOrder(@RequestParam Long id) {
        orderInterface.deleteOrder(id);
        return "Order deleted successfully" + id;
    }



}
