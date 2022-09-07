package com.example.tupaph13622_assjv6.service;

import com.example.tupaph13622_assjv6.entity.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();

    Product findById(Integer id);

    Product save(Product product);

    void deleteById(Integer id);
}
