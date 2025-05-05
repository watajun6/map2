package com.example.ogumap.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.ogumap.security.OgumapUserDetails;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(@AuthenticationPrincipal OgumapUserDetails user, Model model) {
        String role = user.getAuthorities().stream().findFirst().get().getAuthority();
        model.addAttribute("username", user.getUsername());
        switch (role) {
            case "ROLE_ADMIN":   return "admin/adminhome";
            case "ROLE_SHOP":    return "shop/shophome";
            case "ROLE_COMPANY": return "company/companyhome";
            default:             return "login";
        }
    }
}