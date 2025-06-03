package com.example.ogumap.shop.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ogumap.entity.Shop;
import com.example.ogumap.shop.dto.ShopDetailDto;

@Repository
public interface ShopDetailRepository extends JpaRepository<Shop, Long> {

    /**
     * ログイン中の会員 username（Principal#getName()）で
     * 自分のショップ詳細を DTO として取得する
     */
	@Query("""
	        SELECT new com.example.ogumap.shop.dto.ShopDetailDto(
	            m.id, m.username, m.email,
	            s.id, s.shopName, s.address, s.category1, s.category2_1, s.category2_2,
	            s.latitude, s.longitude, s.phoneNumber, s.website, m.username
	        )
	        FROM Shop s
	         JOIN s.member m
	        WHERE m.username = :username
	    """)
	    Optional<ShopDetailDto> findByMemberUsername(@Param("username") String username);
	}
