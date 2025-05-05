package com.example.ogumap.entity;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "roles")
@NoArgsConstructor 
public class Role {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;  // ROLE_ADMIN, ROLE_SHOP, ROLE_COMPANY
    
    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    private Set<Member> members;

	public String getName() {
		// TODO 自動生成されたメソッド・スタブ
		return this.name;
	}
}