package com.mcan.ticketbooking.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user_tickets")
public class UserTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_ticket_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name = "ticket_id")
    private Ticket ticket;

    @Column(name = "reserved_at")
    private LocalDate reservedAt;

    @Column(name = "reserved_qty")
    private int reservedQty;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private TicketStatus status;
}

