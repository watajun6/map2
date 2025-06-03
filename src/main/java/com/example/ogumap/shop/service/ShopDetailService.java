package com.example.ogumap.shop.service;

import com.example.ogumap.shop.dto.ShopDetailDto;

/**
 * shopName からショップ詳細を取得するサービス
 */
public interface ShopDetailService {
    /**
     * shopName からショップ詳細を取得
     * @param shopName 検索対象のショップ名
     * @return DTO
     */
    ShopDetailDto getShopDetailByShopName(String shopName);
    
    ShopDetailDto getShopDetailByMemberId(Long memberId);
}