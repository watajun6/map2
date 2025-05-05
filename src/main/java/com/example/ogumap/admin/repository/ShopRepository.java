package com.example.ogumap.admin.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ogumap.admin.dto.ShopMemberDTO;
import com.example.ogumap.entity.Shop;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {
    @Query("SELECT new com.example.ogumap.admin.dto.ShopMemberDTO(m.id, m.username, m.email, s.id, s.shopName, s.address, s.category1, s.category2_1, s.category2_2, s.latitude, s.longitude, s.phoneNumber, s.website) " +
           "FROM Shop s JOIN s.member m")
    Page<ShopMemberDTO> findAllShopMemberData(Pageable pageable); // ページネーション対応
    
    // 検索クエリ対応
    @Query("SELECT new com.example.ogumap.admin.dto.ShopMemberDTO(m.id, m.username, m.email, s.id, s.shopName, s.address, s.category1, s.category2_1, s.category2_2, s.latitude, s.longitude, s.phoneNumber, s.website) " +
           "FROM Shop s JOIN s.member m " +
           "WHERE LOWER(s.shopName) LIKE LOWER(CONCAT('%', :search, '%')) " +
           "   OR LOWER(s.address) LIKE LOWER(CONCAT('%', :search, '%')) " +
           "   OR LOWER(m.username) LIKE LOWER(CONCAT('%', :search, '%'))")
    Page<ShopMemberDTO> findShopsBySearchQuery(String search, Pageable pageable);
    
    // ショップ詳細取得用クエリ
    @Query("SELECT new com.example.ogumap.admin.dto.ShopMemberDTO(m.id, m.username, m.email, s.id, s.shopName, s.address, s.category1, s.category2_1, s.category2_2, s.latitude, s.longitude, s.phoneNumber, s.website) " +
           "FROM Shop s JOIN s.member m " +
           "WHERE s.id = :shopId")
    Optional<ShopMemberDTO> findShopMemberDTOById(@Param("shopId") Long shopId);
}