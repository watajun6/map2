package com.example.ogumap.admin.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.ogumap.admin.dto.CompanyMemberDTO;
import com.example.ogumap.admin.repository.CompanyRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    // ページネーション対応メソッド
    public Page<CompanyMemberDTO> getAllCompanyWithMembers(Pageable pageable) {
        return companyRepository.findAllCompanyMemberData(pageable);
    }
    
    // 検索機能を実装
    public Page<CompanyMemberDTO> searchCompaniesWithMembers(String search2, Pageable pageable) {
        return companyRepository.findCompaniesBySearchQuery(search2, pageable);
    }

    // 企業詳細情報取得
    public CompanyMemberDTO getCompanyDetail(Long companyId) {
        return companyRepository.findCompanyMemberDTOById(companyId)
                .orElseThrow(() -> new EntityNotFoundException("Company not found for id: " + companyId));
        }
    }