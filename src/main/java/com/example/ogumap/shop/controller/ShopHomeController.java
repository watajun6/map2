package com.example.ogumap.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shophome")
public class ShopHomeController {

    @GetMapping
    public String shophome() {
        // 管理画面トップ用のビュー (shophome.html) を返す
        return "shop/shophome";
    }
}