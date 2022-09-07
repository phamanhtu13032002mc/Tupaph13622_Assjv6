package com.example.tupaph13622_assjv6.service.impl;

import com.example.tupaph13622_assjv6.respository.CategoryRepository;
import com.example.tupaph13622_assjv6.entity.Category;
import com.example.tupaph13622_assjv6.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository cateR;

    @Override
    public List<Category> findAll() {
        return cateR.findAll();
    }



}
