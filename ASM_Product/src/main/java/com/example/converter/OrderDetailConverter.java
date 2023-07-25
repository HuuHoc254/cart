package com.example.converter;

import com.example.domain.OrderDetail;
import com.example.entity.OrderDetailEntity;
import com.example.entity.OrderEntity;

import java.util.List;
import java.util.stream.Collectors;

public class OrderDetailConverter {

    public static List<OrderDetailEntity> toEntity(List<OrderDetail> items) {
        return items.stream().map(item -> {
            OrderDetailEntity orderDetailEntity = new OrderDetailEntity();
            orderDetailEntity.setProductEntity(ProductConverter.toEntity(item.getProduct()));
            orderDetailEntity.setQuantity(item.getQuantity());
            return orderDetailEntity;
        }).collect(Collectors.toList());
    }
}
