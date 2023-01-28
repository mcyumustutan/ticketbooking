package com.mcan.ticketbooking.service;

import com.mcan.ticketbooking.model.UserTicket;

import java.util.List;

public interface UserTicketService {


    List<UserTicket> findUserTickets();
}
