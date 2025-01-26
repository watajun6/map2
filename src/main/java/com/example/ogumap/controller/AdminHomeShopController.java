package com.example.ogumap.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ogumap.dto.ShopMemberDTO;
import com.example.ogumap.service.ShopService;

@Controller
@RequestMapping("/admin/shops")
public class AdminHomeShopController {

    private ShopService shopService = null;

    public AdminHomeShopController(ShopService shopService) {
        this.shopService = shopService;
    }

//    page：ページ番号（デフォルトは0）
//    size：サイズ（1ページあたりの表示数、デフォルトは10）
//    sort：並べ替える対象（デフォルトはなし）
//    direction：並べ替える順番（デフォルトはDirection.ASC）
    @GetMapping
    public String listShops(Model model, @PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC) Pageable pageable) {
    	Page<ShopMemberDTO> shopsPage = shopService.getAllShopsWithMembers(pageable);
        model.addAttribute("shopsPage", shopsPage);
        return "admin/shop/index";
    }
}