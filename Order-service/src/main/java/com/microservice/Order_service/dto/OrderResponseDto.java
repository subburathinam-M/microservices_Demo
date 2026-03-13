package com.microservice.Order_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponseDto {

    private Long orderId;
    private Long productId;
    private int quantity;
    private double totalPrice;

    // product details

    private String productName;
    private double productPrice;

}
