package com.example.ogumap.company.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDetailDto {
    private Long memberId;       // ID
    private String memberName;   // ユーザー名
    private String memberEmail;  // メールアドレス
    
    // companies テーブル
	private Long companyId;			// 会社ID
	private String companyName;		// 会社名
	private String address;			// 住所
	private Double latitude;		// 緯度
	private Double longitude;		// 経度
	private String contactEmail;	// メールアドレス
	private String phoneNumber;		// 電話番号
	private String ownerUsername;	// オーナー (Member.username)
}
