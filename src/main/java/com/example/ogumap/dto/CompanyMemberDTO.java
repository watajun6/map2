package com.example.ogumap.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyMemberDTO {
	// Members テーブル
    private Long memberId;       // ID
    private String memberName;   // ユーザー名
    private String memberEmail;  // メールアドレス
//    private String memberRole;

    // companies テーブル
    private Long companyId;
    private String companyName;  // 会社名
    private String companyAddress;  // 住所
    private String contactEmail;  // メールアドレス
    private String phoneNumber;  // 電話番号
    private Double latitude;     // 緯度
    private Double longitude;    // 経度
//    private String website;      // ウェブサイト
    }

