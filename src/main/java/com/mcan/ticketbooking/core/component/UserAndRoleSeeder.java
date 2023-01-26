package com.mcan.ticketbooking.core.component;

import com.mcan.ticketbooking.model.*;
import com.mcan.ticketbooking.repository.RoleRepository;
import com.mcan.ticketbooking.repository.TicketRepository;
import com.mcan.ticketbooking.repository.UserRepository;
import com.mcan.ticketbooking.repository.UserTicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class UserAndRoleSeeder implements ApplicationRunner {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private UserTicketRepository userTicketRepository;

    private LocalDate globalStartDate;
    private LocalDate globalFinishDate;

    @Override
    public void run(ApplicationArguments args) throws Exception {


        Role roleAdmin = Role.builder().id(1L).roleName("ROLE_ADMIN").build();
        Role roleUser = Role.builder().id(2L).roleName("ROLE_USER").build();

        roleRepository.save(roleAdmin);
        roleRepository.save(roleUser);

        List<Role> adminRoleList = new ArrayList<>();
        adminRoleList.add(roleAdmin);

        List<Role> userRoleList = new ArrayList<>();
        userRoleList.add(roleUser);

        User admin = User.builder()
                .id(1L)
                .name("admin")
                .email("admin@g.com")
                .password(passwordEncoder.encode("12345678"))
                .roles(adminRoleList).build();
        userRepository.save(admin);

        User user = User.builder().id(2L)
                .name("usercan")
                .email("user@g.com")
                .password(passwordEncoder.encode("12345678"))
                .roles(userRoleList).build();
        userRepository.save(user);

        User user1 = User.builder().id(2L)
                .name("democan")
                .email("demo@g.com")
                .password(passwordEncoder.encode("12345678"))
                .roles(userRoleList).build();
        userRepository.save(user1);


        this.globalStartDate = LocalDate.now().minusDays(50);
        this.globalFinishDate = LocalDate.now().plusDays(50);

        Ticket ticket1 = Ticket.builder()
                .id(1L)
                .start("Adana")
                .finish("İstabul")
                .seatQty(65)
                .price(BigDecimal.valueOf(465))
                .availableStart(this.globalStartDate)
                .availableFinish(this.globalFinishDate)
                .build();
        ticketRepository.save(ticket1);

        Ticket ticket2 = Ticket.builder()
                .id(1L)
                .start("Adana")
                .finish("Ankara")
                .seatQty(60)
                .price(BigDecimal.valueOf(405))
                .availableStart(this.globalStartDate)
                .availableFinish(this.globalFinishDate)
                .build();
        ticketRepository.save(ticket2);

        Ticket ticket3 = Ticket.builder()
                .id(1L)
                .start("Adana")
                .finish("Eskişehir")
                .seatQty(40)
                .price(BigDecimal.valueOf(355))
                .availableStart(this.globalStartDate)
                .availableFinish(this.globalFinishDate)
                .build();
        ticketRepository.save(ticket3);

        Ticket ticket4 = Ticket.builder()
                .id(1L)
                .start("Adana")
                .finish("İzmir")
                .seatQty(40)
                .price(BigDecimal.valueOf(455))
                .availableStart(this.globalStartDate)
                .availableFinish(LocalDate.now().plusDays(50))
                .build();
        ticketRepository.save(ticket4);


        List<User> demoUsers = userRepository.findAll();
        List<Ticket> demoTickets = ticketRepository.findAll();

        UserTicket UserTicket1 = UserTicket.builder()
                .user(demoUsers.get(1))
                .ticket(demoTickets.get(1))
                .reservedAt(LocalDate.now())
                .reservedQty(1)
                .status(TicketStatus.RESERVED)
                .build();
        userTicketRepository.save(UserTicket1);

        UserTicket UserTicket2 = UserTicket.builder()
                .user(demoUsers.get(1))
                .ticket(demoTickets.get(2))
                .reservedAt(LocalDate.now())
                .reservedQty(1)
                .status(TicketStatus.POSTPONED)
                .build();
        userTicketRepository.save(UserTicket2);

        UserTicket UserTicket3 = UserTicket.builder()
                .user(demoUsers.get(2))
                .ticket(demoTickets.get(2))
                .reservedAt(LocalDate.now())
                .reservedQty(1)
                .status(TicketStatus.RESERVED)
                .build();
        userTicketRepository.save(UserTicket3);



    }
}
