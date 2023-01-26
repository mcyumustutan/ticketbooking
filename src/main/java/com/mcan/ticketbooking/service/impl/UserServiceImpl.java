package com.mcan.ticketbooking.service.impl;


import com.mcan.ticketbooking.model.User;
import com.mcan.ticketbooking.model.UserTicket;
import com.mcan.ticketbooking.repository.UserRepository;
import com.mcan.ticketbooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {


    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> findById(long l) {
        return this.userRepository.findById(l);
    }
}
