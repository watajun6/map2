package com.example.ogumap.controller;

import java.util.List;

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

    @GetMapping
    public String index(Model model) {
        List<CompanyMemberDTO> companies = companyService.getAllCompaniesWithMembers();
        model.addAttribute("companies", companies);
        return "admin/companies/index";
    }
}