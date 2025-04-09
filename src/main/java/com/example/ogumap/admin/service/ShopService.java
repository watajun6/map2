package com.example.ogumap.admin.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.ogumap.admin.dto.ShopMemberDTO;
import com.example.ogumap.admin.repository.ShopRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ShopService {

    private final ShopRepository shopRepository;

    public ShopService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    // 全ての店舗情報を取得
    // ページネーション対応メソッド
    public Page<ShopMemberDTO> getAllShopWithMembers(Pageable pageable) {
        return shopRepository.findAllShopMemberData(pageable);
    }
    
    // 検索結果を取得
    public Page<ShopMemberDTO> searchShopsWithMembers(String search, Pageable pageable) {
        return shopRepository.findShopsBySearchQuery(search, pageable);
    }
    // ショップ詳細情報取得
    public ShopMemberDTO getShopDetail(Long shopId) {
        return shopRepository.findShopMemberDTOById(shopId)
                .orElseThrow(() -> new EntityNotFoundException("Shop not found for id: " + shopId));
    }
}