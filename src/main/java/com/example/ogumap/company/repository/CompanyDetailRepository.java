package com.example.ogumap.company.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.ogumap.company.dto.CompanyDetailDto;
import com.example.ogumap.entity.Company;

@Repository
public interface CompanyDetailRepository extends JpaRepository<Company, Long> {
	@Query("""
			SELECT new com.example.ogumap.company.dto.CompanyDetailDto(
				m.id, m.username, m.email,
				c.id, c.companyName, c.address,
				c.latitude, c.longitude, c.contactEmail, c.phoneNumber, m.username
			)
			FROM Company c
			JOIN c.member m
			WHERE m.username = :username
			""")
	Optional<CompanyDetailDto> findByMemberUsername(@Param("username") String username);
}
