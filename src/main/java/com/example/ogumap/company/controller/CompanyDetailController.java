package com.example.ogumap.company.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ogumap.company.dto.CompanyDetailDto;
import com.example.ogumap.company.repository.CompanyDetailRepository;

@Controller
@RequestMapping("/company")
public class CompanyDetailController {

    private final CompanyDetailRepository companyDetailRepository;

    public CompanyDetailController(CompanyDetailRepository companyDetailRepository) {
        this.companyDetailRepository = companyDetailRepository;
    }

    @GetMapping("/companydetail")
    public String companyDetail(Principal principal, Model model) {

    	String username = principal.getName();
    	CompanyDetailDto dto = companyDetailRepository
            .findByMemberUsername(username)
            .orElseThrow(() -> new IllegalStateException(
                "この会員に紐づくショップが見つかりません: " + username));
        model.addAttribute("companyDetail", dto);
        return "company/companydetail";
    }
}
