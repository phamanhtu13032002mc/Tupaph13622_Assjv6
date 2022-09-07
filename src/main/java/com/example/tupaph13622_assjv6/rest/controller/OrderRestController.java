package com.example.tupaph13622_assjv6.rest.controller;

import com.example.tupaph13622_assjv6.entity.Order;
import com.example.tupaph13622_assjv6.service.OrderService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/orders")
public class OrderRestController {
    @Autowired
    OrderService orderService;
    @PostMapping()
    public Order create(@RequestBody JsonNode orderData){
        return orderService.create(orderData);
    }

}
