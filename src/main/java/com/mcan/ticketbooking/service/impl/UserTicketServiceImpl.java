package com.mcan.ticketbooking.service.impl;

import com.mcan.ticketbooking.model.UserTicket;
import com.mcan.ticketbooking.repository.UserTicketRepository;
import com.mcan.ticketbooking.service.UserTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserTicketServiceImpl implements UserTicketService {

    private UserTicketRepository userTicketRepository;

    @Autowired
    public UserTicketServiceImpl(UserTicketRepository userTicketRepository ){
        this.userTicketRepository = userTicketRepository;
    }

    @Override
    public List<UserTicket> findUserTickets(Long user_id) {
        return null;
    }
}
