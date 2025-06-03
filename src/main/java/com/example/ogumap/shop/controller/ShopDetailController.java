package com.example.ogumap.shop.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ogumap.shop.dto.ShopDetailDto;
import com.example.ogumap.shop.repository.ShopDetailRepository;

@Controller
@RequestMapping("/shop")
public class ShopDetailController {

    private final ShopDetailRepository shopDetailRepository;

    public ShopDetailController(ShopDetailRepository shopDetailRepository) {
        this.shopDetailRepository = shopDetailRepository;
    }

    @GetMapping("/shopdetail")
    public String shopDetail(Principal principal, Model model) {

    	String username = principal.getName();
        ShopDetailDto dto = shopDetailRepository
            .findByMemberUsername(username)
            .orElseThrow(() -> new IllegalStateException(
                "この会員に紐づくショップが見つかりません: " + username));
        model.addAttribute("shopDetail", dto);
        return "shop/shopdetail";
    }
}
