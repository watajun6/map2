package com.example.ogumap.admin.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ogumap.admin.dto.CompanyMemberDTO;
import com.example.ogumap.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
	// ページネーション対応
    @Query("SELECT new com.example.ogumap.admin.dto.CompanyMemberDTO(m.id, m.username, m.email, c.id, c.companyName, c.address, c.contactEmail, c.phoneNumber, c.latitude, c.longitude) " +
           "FROM Company c JOIN c.member m")
    Page<CompanyMemberDTO> findAllCompanyMemberData(Pageable pageable); 
    
    // 検索クエリ対応メソッド
    @Query("SELECT new com.example.ogumap.admin.dto.CompanyMemberDTO(m.id, m.username, m.email, c.id, c.companyName, c.address, c.contactEmail, c.phoneNumber, c.latitude, c.longitude) " +
           "FROM Company c JOIN c.member m " +
           "WHERE (:search2 IS NULL OR :search2 = '' OR " +
           "LOWER(c.companyName) LIKE LOWER(CONCAT('%', :search2, '%')) OR " + // 会社名で検索
           "LOWER(c.address) LIKE LOWER(CONCAT('%', :search2, '%')) OR " +    // 住所で検索
    	   "LOWER(m.username) LIKE LOWER(CONCAT('%', :search2, '%')))")    // ユーザー名で検索
    Page<CompanyMemberDTO> findCompaniesBySearchQuery(@RequestParam("search2") String search2, Pageable pageable);
    
    // ショップ詳細取得用クエリ
    @Query("SELECT new com.example.ogumap.admin.dto.CompanyMemberDTO(m.id, m.username, m.email, c.id, c.companyName, c.address, c.contactEmail, c.phoneNumber, c.latitude, c.longitude) " +
            "FROM Company c JOIN c.member m " +
            "WHERE c.id = :companyId")
     Optional<CompanyMemberDTO> findCompanyMemberDTOById(@Param("companyId") Long companyId);
 }