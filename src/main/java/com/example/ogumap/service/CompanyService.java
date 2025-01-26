package com.example.ogumap.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ogumap.dto.CompanyMemberDTO;
import com.example.ogumap.repository.CompanyRepository;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<CompanyMemberDTO> getAllCompaniesWithMembers() {
        return companyRepository.findAllCompanyMemberData();
    }
}