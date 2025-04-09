package com.example.ogumap.admin.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ogumap.admin.dto.ShopMemberDTO;
import com.example.ogumap.admin.service.ShopService;

@Controller
@RequestMapping("/admin/shop")
public class AdminHomeShopController {

	private final ShopService shopService;

    public AdminHomeShopController(ShopService shopService) {
        this.shopService = shopService;
    }

//    page：ページ番号（デフォルトは0）
//    size：サイズ（1ページあたりの表示数、デフォルトは10）
//    sort：並べ替える対象（デフォルトはなし）
//    direction：並べ替える順番（デフォルトはDirection.ASC）
    @GetMapping
    public String listShops(
    		Model model,
    		@PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC) Pageable pageable,
    		@RequestParam(value = "search", required = false) String search // 検索条件
    		) {
    	Page<ShopMemberDTO> shopsPage;
    	if (search != null && !search.isEmpty()) {
            shopsPage = shopService.searchShopsWithMembers(search, pageable);
        } else {
            shopsPage = shopService.getAllShopWithMembers(pageable);
        }
        model.addAttribute("shopsPage", shopsPage);
        model.addAttribute("search", search); // 検索条件をテンプレートに渡す
        return "admin/shop/shoplist";
    }
    
    // ショップ詳細表示
    @GetMapping("/show/{shopId}")
    public String shopShow(@PathVariable("shopId") Long shopId, Model model) {
        ShopMemberDTO shopDetail = shopService.getShopDetail(shopId);
        model.addAttribute("shopDetail", shopDetail);
        return "admin/shop/show";
    }
}