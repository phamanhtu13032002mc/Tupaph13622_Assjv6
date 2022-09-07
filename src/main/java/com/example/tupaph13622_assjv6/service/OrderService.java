package com.example.tupaph13622_assjv6.service;

import com.example.tupaph13622_assjv6.entity.Order;
import com.fasterxml.jackson.databind.JsonNode;

import java.util.List;

public interface OrderService {


    Order create(JsonNode orderData);
    Order findById(Integer id);

    List<Order> findByUsername(String username);
}
