package com.example.service;

import com.example.entity.OrderDetailEntity;
import com.example.entity.OrderEntity;

import java.util.List;

public interface OrderService {
    void saveOrder(OrderEntity orderEntity, List<OrderDetailEntity> orderDetailEntity);
}
