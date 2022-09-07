package com.example.tupaph13622_assjv6.rest.controller;

import com.example.tupaph13622_assjv6.respository.CategoryRepository;
import com.example.tupaph13622_assjv6.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/rest/categories")
public class CategoryRestController {
    @Autowired
    CategoryRepository categoryService;

    @GetMapping()
    public List<Category> getAll() {
        return categoryService.findAll();
    }
    @PostMapping
    public Category create(@RequestBody Category category) {
        return categoryService.save(category);
    }

    @PutMapping("{id}")
    public Category update(@PathVariable("id") Integer id, @RequestBody Category category) {
        return categoryService.save(category);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") String id) {
        categoryService.deleteById(id);
    }
}
