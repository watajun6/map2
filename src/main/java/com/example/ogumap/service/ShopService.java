package com.example.ogumap.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.ogumap.dto.ShopMemberDTO;
import com.example.ogumap.repository.ShopRepository;

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

}