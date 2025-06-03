//package com.example.ogumap.shop.service;
//
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.example.ogumap.entity.Member;
//import com.example.ogumap.entity.Shop;
//import com.example.ogumap.shop.dto.ShopDetailDto;
//import com.example.ogumap.shop.repository.ShopDetailRepository;
//
//import jakarta.persistence.EntityNotFoundException;
//
//@Service
//@Transactional(readOnly = true)
//public class ShopDetailServiceImpl implements ShopDetailService {
//
//    private final ShopDetailRepository shopRepo;
//
//    public ShopDetailServiceImpl(ShopDetailRepository shopRepo) {
//        this.shopRepo = shopRepo;
//    }
//
//    @Override
//    public ShopDetailDto getShopDetailByShopName(String shopName) {
//        Shop shop = shopRepo.findByShopName(shopName)
//            .orElseThrow(() -> new EntityNotFoundException("ショップが見つかりません: " + shopName));
//        return buildDto(shop);
//    }
//
//    @Override
//    public ShopDetailDto getShopDetailByMemberId(Long memberId) {
//        Shop shop = shopRepo.findByMemberId(memberId)
//            .orElseThrow(() -> new EntityNotFoundException("この会員に紐づくショップが見つかりません: memberId=" + memberId));
//        return buildDto(shop);
//    }
//
//    // 既存の builder チェーンに member 情報を追加
//    private ShopDetailDto buildDto(Shop shop) {
//        Member m = shop.getMember();
//        return ShopDetailDto.builder()
//            .memberId(m.getId())
//            .memberName(m.getUsername())
//            .memberEmail(m.getEmail())
//            .shopId(shop.getId())
//            .shopName(shop.getShopName())
//            .shopAddress(shop.getAddress())
//            .category1(shop.getCategory1())
//            .category2_1(shop.getCategory2_1())
//            .category2_2(shop.getCategory2_2())
//            .latitude(shop.getLatitude())
//            .longitude(shop.getLongitude())
//            .phoneNumber(shop.getPhoneNumber())
//            .website(shop.getWebsite())
//            .ownerUsername(m.getUsername())
//            .build();
//    }
//}
