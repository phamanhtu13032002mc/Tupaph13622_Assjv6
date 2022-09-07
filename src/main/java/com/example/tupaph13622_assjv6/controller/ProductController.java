package com.example.tupaph13622_assjv6.controller;
import com.example.tupaph13622_assjv6.entity.Product;
import com.example.tupaph13622_assjv6.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;
    @RequestMapping("/product/list")
    public String List(Model model){
        List<Product> list = productService.findAll();
        model.addAttribute("item",list);
     return "product/list";
    }
    @RequestMapping("/product/detail/{id}")
    public String detail( Model model,@PathVariable("id") Integer id){
        Product item = productService.findById(id);
        model.addAttribute("item",item);
        return "product/detail";
    }
}
