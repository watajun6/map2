package com.example.ogumap.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.ogumap.dto.CompanyMemberDTO;
import com.example.ogumap.repository.CompanyRepository;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    // ページネーション対応メソッド
    public Page<CompanyMemberDTO> getAllCompaniesWithMembers(Pageable pageable) {
        return companyRepository.findAllCompanyMemberData(pageable);
    }
}