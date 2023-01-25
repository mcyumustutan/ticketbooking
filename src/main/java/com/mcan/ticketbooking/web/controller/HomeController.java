package com.mcan.ticketbooking.web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Value("${spring.application.name}")
    String appName;

    @GetMapping("/simple")
    public String simple(Model model) {
        model.addAttribute("appName", appName);
        return "home";
    }


    @GetMapping("/home")
    public String homePage(Model model) {
        model.addAttribute("appName", "Welcome home");
        return "home";
    }



    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("appName", "Welcome Admin");
        return "home";
    }

}
