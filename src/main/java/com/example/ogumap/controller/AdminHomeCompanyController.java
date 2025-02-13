package com.example.ogumap.controller;

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

import com.example.ogumap.dto.CompanyMemberDTO;
import com.example.ogumap.service.CompanyService;

@Controller
@RequestMapping("/admin/company")
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
    public String companyList(
    		Model model,
    		@PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC) Pageable pageable,
    		@RequestParam(value = "search2", required = false, defaultValue = "") String search2 // 検索条件
    	    ) {
    	Page<CompanyMemberDTO> companiesPage;
        if (!search2.isEmpty()) { // 検索条件が空でない場合
            companiesPage = companyService.searchCompaniesWithMembers(search2, pageable);
        } else {
            companiesPage = companyService.getAllCompanyWithMembers(pageable);
        }
        model.addAttribute("companiesPage", companiesPage);
        model.addAttribute("search2", search2); // ビューに検索条件を渡す
        return "admin/company/companylist";
    }
    
    // 企業詳細表示（例：/admin/company/show/{companyId}）
    @GetMapping("/show/{companyId}")
    public String showCompany(@PathVariable("companyId") Long companyId, Model model) {
        CompanyMemberDTO companyDetail = companyService.getCompanyDetail(companyId);
        model.addAttribute("companyDetail", companyDetail);
        return "admin/company/show";
    }
}