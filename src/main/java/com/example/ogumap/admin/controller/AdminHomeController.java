package com.example.ogumap.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/adminhome")
public class AdminHomeController {

    @GetMapping
    public String adminhome() {
        // 管理画面トップ用のビュー (admin/adminhome.html) を返す
        return "admin/adminhome";
    }
}