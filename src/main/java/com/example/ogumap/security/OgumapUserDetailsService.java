package com.example.ogumap.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.ogumap.entity.Member;
import com.example.ogumap.repository.MemberRepository;

@Service
public class OgumapUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepo;

    public OgumapUserDetailsService(MemberRepository repo) {
        this.memberRepo = repo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Member m = memberRepo.findByUsername(username)
                     .orElseThrow(() -> new UsernameNotFoundException("ユーザーが見つかりません"));
        return new OgumapUserDetails(m);
    }
}
