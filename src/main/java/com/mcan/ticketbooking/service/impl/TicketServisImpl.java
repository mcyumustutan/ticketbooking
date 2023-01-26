package com.mcan.ticketbooking.service.impl;

import com.mcan.ticketbooking.model.Ticket;
import com.mcan.ticketbooking.repository.TicketRepository;
import com.mcan.ticketbooking.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketServisImpl implements TicketService {

    private TicketRepository ticketRepository;

    @Autowired
    public TicketServisImpl(TicketRepository ticketRepository){
        this.ticketRepository = ticketRepository;
    }

    @Override
    public List<Ticket> getUserTickets() {
        return ticketRepository.findAll();
    }
}
