package com.example.ogumap.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ogumap.dto.CompanyMemberDTO;
import com.example.ogumap.service.CompanyService;

@Controller
@RequestMapping("/admin/companies")
public class AdminHomeCompanyController {

    private final CompanyService companyService;

    public AdminHomeCompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

//  page：ページ番号（デフォルトは0）
//  size：サイズ（1ページあたりの表示数、デフォルトは10）
//  sort：並べ替える対象（デフォルトはなし）
//  direction：並べ替える順番（デフォルトはDirection.ASC）
    @GetMapping
    public String listCompanies(Model model, @PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC) Pageable pageable) {
    	Page<CompanyMemberDTO> companiesPage = companyService.getAllCompaniesWithMembers(pageable);
        model.addAttribute("companiesPage", companiesPage);
        return "admin/company/index";
    }
}