package com.example.tupaph13622_assjv6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {
    @RequestMapping("/security/login/form")
    public String loginForm(Model model){
        model.addAttribute("message","Phải đăng nhập nha");
        return "security/login";
    }
    @RequestMapping("/security/login/success")
    public String loginSuccess(Model model){
        model.addAttribute("message","Dang nhap thanh cong");
        return "security/login";
    }
    @RequestMapping("/security/login/error")
    public String loginError(Model model){
        model.addAttribute("message","Dang nhap that bai");
        return "security/login";
    }
    @RequestMapping("/security/unauthoried")
    public String unauthoried(Model model) {
        model.addAttribute("message", "Không có quyền truy cap");
        return "security/login";
    }
    @RequestMapping("/security/logoff/success")
    public String logoffSuccess(Model model) {
        model.addAttribute("message", "Bạn đã đăng xuất");
        return "security/login";
    }




}
