package com.example.tupaph13622_assjv6.service.impl;

import com.example.tupaph13622_assjv6.respository.ProductRepository;
import com.example.tupaph13622_assjv6.entity.Product;
import com.example.tupaph13622_assjv6.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl  implements ProductService {
    @Autowired
    ProductRepository proRe;

    @Override
    public List<Product> findAll() {
        return proRe.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return proRe.findById(id).get();
    }

    @Override
    public Product save(Product product) {
        return proRe.save(product);
    }

    @Override
    public void deleteById(Integer id) {

    }

}
