package com.example.converter;

import com.example.domain.Order;
import com.example.entity.OrderEntity;

public class OrderConverter {
    public static OrderEntity toEntity(Order order) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderDate(order.getDate());
        orderEntity.setCustomerAddress(order.getCustomerAddress());
        orderEntity.setCustomerName(order.getCustomerName());
        return orderEntity;
    }
}
