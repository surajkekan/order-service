package com.suncart.orderservice.controller;

import com.suncart.orderservice.dto.OrderRequestDTO;
import com.suncart.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequestDTO orderRequest){
        orderService.placeOrder(orderRequest);
        return "Order Placed Successfully";
    }
}
