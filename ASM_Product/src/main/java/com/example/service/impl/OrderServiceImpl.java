package com.example.service.impl;

import com.example.entity.OrderDetailEntity;
import com.example.entity.OrderEntity;
import com.example.repository.OrderDetailRepository;
import com.example.repository.OrderRepository;
import com.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void saveOrder(OrderEntity orderEntity, List<OrderDetailEntity> orderDetailEntity) {
        orderEntity = orderRepository.save(orderEntity);
        OrderEntity finalOrderEntity = orderEntity;
        orderDetailEntity.forEach(item ->{
            item.setOrderEntity(finalOrderEntity);
            orderDetailRepository.save(item);
        });
    }
}
