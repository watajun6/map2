package com.example.ogumap.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/shop")
public class ShopHomeController {
	/** 
	 * /shop へのアクセスは /shop/home にリダイレクト 
	 */
	@GetMapping
	public String root() {
	    return "redirect:/shop/home";
	}
	
	/**
	 * /shop/home へのアクセスでテンプレート shop/shophome.html を返す
	 */
	@GetMapping("/home")
	public String home() {
	    return "shop/shophome";
	}
}