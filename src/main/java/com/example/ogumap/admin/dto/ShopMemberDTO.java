package com.example.ogumap.admin.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShopMemberDTO {
	// Members テーブル
    private Long memberId;       // ID
    private String memberName;   // ユーザー名
    private String memberEmail;  // メールアドレス

    // Shops テーブル
    private Long shopId;         // 店舗ID
    private String shopName;     // 店舗名
    private String shopAddress;  // 住所
    private String category1;    // カテゴリ1
    private String category2_1;  // カテゴリ2-1
    private String category2_2;  // カテゴリ2-2
    private Double latitude;     // 緯度
    private Double longitude;    // 経度
    private String phoneNumber;  // 電話番号
    private String website;      // ウェブサイト
}
