package com.example.tupaph13622_assjv6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShoppingCartController {
    @RequestMapping("/cart/view")
    private String view(){
        return "cart/view";
    }
}
