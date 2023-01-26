package com.mcan.ticketbooking.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tickets")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ticket_id")
    private Long id;

    @Column(name = "start", nullable = false)
    private String start;

    @Column(name = "finish", nullable = false)
    private String finish;

    @Column(name = "seatQty", nullable = false)
    private int seatQty;

    @Column(name = "price", nullable = false)
    private BigDecimal price;

    @Column(name = "availableStart", nullable = false)
    private LocalDate availableStart;

    @Column(name = "availableFinish", nullable = false)
    private LocalDate availableFinish;

    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL)
    private Set<UserTicket> userTickets = new HashSet<>();

}
