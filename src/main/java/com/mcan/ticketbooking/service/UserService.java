package com.mcan.ticketbooking.service;

import com.mcan.ticketbooking.model.User;
import com.mcan.ticketbooking.model.UserTicket;

import java.util.Optional;
import java.util.Set;

public interface UserService {

    Optional<User> findById(long l);
}
