package com.mcan.ticketbooking.repository;

import com.mcan.ticketbooking.model.UserTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserTicketRepository extends JpaRepository<UserTicket, Long> {

    @Query(value = "select t.* from user_tickets t where t.user_id = ?#{ principal?.id }", nativeQuery = true)
    List<UserTicket> findAll();
}
