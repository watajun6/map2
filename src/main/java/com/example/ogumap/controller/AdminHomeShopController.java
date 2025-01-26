package com.example.ogumap.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ogumap.dto.ShopMemberDTO;
import com.example.ogumap.service.ShopService;

@Controller
@RequestMapping("/shops")
public class AdminHomeShopController {

    private ShopService shopService = null;

    public AdminHomeShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping
    public String listShops(Model model) {
        List<ShopMemberDTO> shops = shopService.getAllShopsWithMembers();
        model.addAttribute("shops", shops);
        return "admin/shop/index";
    }
}