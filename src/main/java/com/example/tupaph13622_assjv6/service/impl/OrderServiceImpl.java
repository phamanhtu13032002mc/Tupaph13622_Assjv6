package com.example.tupaph13622_assjv6.service.impl;

import com.example.tupaph13622_assjv6.respository.OrderRepository;
import com.example.tupaph13622_assjv6.respository.OrderDetailRepository;
import com.example.tupaph13622_assjv6.entity.Order;
import com.example.tupaph13622_assjv6.entity.OrderDetail;
import com.example.tupaph13622_assjv6.service.OrderService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderDetailRepository ddao;


    @Override
    public Order create(JsonNode orderData) {
        ObjectMapper mapper = new ObjectMapper();
        Order order = mapper.convertValue(orderData, Order.class);
        orderRepository.save(order);

        TypeReference<List<OrderDetail>> type = new TypeReference<List<OrderDetail>>() {
        };
        List<OrderDetail> detail = mapper.convertValue(orderData.get("orderDetails"), type)
                .stream().peek(d -> d.setOrder(order)).collect(Collectors.toList());
        ddao.saveAll(detail);
        return order;
    }

    @Override
    public Order findById(Integer id) {
        return orderRepository.findById(id).get();
    }

    @Override
    public List<Order> findByUsername(String username) {
        return orderRepository.findByUsername(username);
    }


}
