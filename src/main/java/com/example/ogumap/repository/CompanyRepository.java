package com.example.ogumap.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.ogumap.dto.CompanyMemberDTO;
import com.example.ogumap.entity.Company;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    @Query("SELECT new com.example.ogumap.dto.CompanyMemberDTO(m.id, m.username, m.email, c.id, c.companyName, c.address, c.contactEmail, c.phoneNumber, c.latitude, c.longitude) " +
           "FROM Company c JOIN c.member m")
    List<CompanyMemberDTO> findAllCompanyMemberData();
}
