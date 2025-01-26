package com.example.ogumap.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.ogumap.dto.ShopMemberDTO;
import com.example.ogumap.entity.Shop;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {
    @Query("SELECT new com.example.ogumap.dto.ShopMemberDTO(m.id, m.username, m.email, s.id, s.shopName, s.address, s.category1, s.category2_1, s.category2_2, s.latitude, s.longitude, s.phoneNumber, s.website) " +
           "FROM Shop s JOIN s.member m")
    Page<ShopMemberDTO> findAllShopMemberData(Pageable pageable); // ページネーション対応
}