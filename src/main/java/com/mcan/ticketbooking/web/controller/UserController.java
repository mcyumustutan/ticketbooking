package com.mcan.ticketbooking.web.controller;

import com.mcan.ticketbooking.model.User;
import com.mcan.ticketbooking.repository.UserRepository;
import com.mcan.ticketbooking.service.TicketService;
import com.mcan.ticketbooking.service.UserService;
import com.mcan.ticketbooking.service.UserTicketService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class UserController {

    private TicketService ticketService;
    private UserService userService;

    private UserTicketService userTicketService;

    private UserRepository userRepository;

    public UserController(TicketService ticketService, UserTicketService userTicketService, UserRepository userRepository, UserService userService) {
        this.ticketService = ticketService;
        this.userTicketService = userTicketService;
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @GetMapping(value = "/home", name = "userHome")
    public String userHome(Model model) {

        Optional<User> myuser = userService.findById(4L);
        System.out.println(myuser);

        model.addAttribute("appName", "Welcome User");
        model.addAttribute("tickets", myuser);

        return "home";
    }
}
