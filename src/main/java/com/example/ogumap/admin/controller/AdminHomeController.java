package com.example.ogumap.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminHomeController {

    /** 
     * /admin へのアクセスは /admin/home にリダイレクト 
     */
    @GetMapping
    public String root() {
        return "redirect:/admin/home";
    }

    /**
     * /admin/home へのアクセスでテンプレート admin/adminhome.html を返す
     */
    @GetMapping("/home")
    public String home() {
        return "admin/adminhome";
    }
}
