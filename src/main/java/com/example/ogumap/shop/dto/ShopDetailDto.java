package com.example.ogumap.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ShopDetailDto {
    private Long id;       // ID
    private String userName;   // ユーザー名
    private String email;  // メールアドレス

    // Shops テーブル
    private Long shopId;         	// 店舗ID
    private String shopName;     	// 店舗名
    private String Address;  	// 住所
    private String category1;    	// カテゴリ1
    private String category2_1;  	// カテゴリ2-1
    private String category2_2;  	// カテゴリ2-2
    private Double latitude;     	// 緯度
    private Double longitude;    	// 経度
    private String phoneNumber;  	// 電話番号
    private String website;      	// ウェブサイト
    private String ownerUsername;	// オーナー (Member.username)
}