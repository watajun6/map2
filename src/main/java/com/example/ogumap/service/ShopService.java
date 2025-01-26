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

    // ページネーション対応メソッド
    public Page<ShopMemberDTO> getAllShopsWithMembers(Pageable pageable) {
        return shopRepository.findAllShopMemberData(pageable);
    }
}