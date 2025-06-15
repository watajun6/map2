package com.example.ogumap.company.service;

import com.example.ogumap.shop.dto.ShopDetailDto;

/**
 * companyName から詳細を取得するサービス
 */
public interface CompanyDetailService {
    /**
     * companyName からショップ詳細を取得
     * @param companyName 検索対象のショップ名
     * @return DTO
     */
    ShopDetailDto getCompanyDetailByCompanyName(String companyName);
    
    ShopDetailDto getCompanyDetailByMemberId(Long memberId);
}
