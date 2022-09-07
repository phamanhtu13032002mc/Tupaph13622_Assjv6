package com.example.tupaph13622_assjv6.rest.controller;

import com.example.tupaph13622_assjv6.respository.ProductRepository;
import com.example.tupaph13622_assjv6.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("rest/products")
public class ProductRestController {
    @Autowired
    ProductRepository productRepository;
    @GetMapping()
    List<Product> getAll(){return productRepository.findAll();}
    @GetMapping("{id}")
    public Optional<Product> getOne(@PathVariable("id")Integer id){
        return productRepository.findById(id);
    }
    @PostMapping
    public Product create(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @PutMapping("{id}")
    public Product update(@PathVariable("id") Integer id, @RequestBody Product product) {
        return productRepository.save(product);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Integer id) {
        productRepository.deleteById(id);
    }

}
