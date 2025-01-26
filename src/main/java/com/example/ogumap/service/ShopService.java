package com.example.ogumap.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ogumap.dto.ShopMemberDTO;
import com.example.ogumap.repository.ShopRepository;

@Service
public class ShopService {

    private final ShopRepository shopRepository;

    public ShopService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public List<ShopMemberDTO> getAllShopsWithMembers() {
        return shopRepository.findAllShopMemberData();
    }
}