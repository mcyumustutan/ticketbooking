package com.mcan.ticketbooking.service;

import com.mcan.ticketbooking.model.Ticket;

import java.util.List;

public interface TicketService {
    List<Ticket> getUserTickets();
}
