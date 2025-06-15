package com.example.ogumap.company.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/company")
public class CompanyHomeController {
	/** 
	 * /company へのアクセスは /company/home にリダイレクト 
	 */
	@GetMapping
	public String root() {
	    return "redirect:/company/home";
	}
	
	/**
	 * /company/home へのアクセスでテンプレート company/companyhome.html を返す
	 */
	@GetMapping("/companyhome")
	public String companyhome() {
	    return "company/companyhome";
	}
}
