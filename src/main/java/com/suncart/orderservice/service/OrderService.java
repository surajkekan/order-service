package com.suncart.orderservice.service;

import com.suncart.orderservice.dto.OrderLineItemsDTO;
import com.suncart.orderservice.dto.OrderRequestDTO;
import com.suncart.orderservice.model.Order;
import com.suncart.orderservice.model.OrderLineItems;
import com.suncart.orderservice.respository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    public void placeOrder(OrderRequestDTO orderRequest){
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItemsList = orderRequest.getOrderLineItemsDTOList()
                .stream()
                .map(this::mapToOrderLineItems).toList();
        order.setOrderLineItemList(orderLineItemsList);
        orderRepository.save(order);
    }

    private OrderLineItems mapToOrderLineItems(OrderLineItemsDTO orderLineItemsDTO){
        OrderLineItems orderlineItems = new  OrderLineItems();

        orderlineItems.setPrice(orderLineItemsDTO.getPrice());
        orderlineItems.setQuantity(orderLineItemsDTO.getQuantity());
        orderlineItems.setSkuCode(orderLineItemsDTO.getSkuCode());

        return  orderlineItems;
    }
}
