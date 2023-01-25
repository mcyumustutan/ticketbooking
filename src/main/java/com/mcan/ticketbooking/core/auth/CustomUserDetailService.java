package com.mcan.ticketbooking.core.auth;

import com.mcan.ticketbooking.model.User;
import com.mcan.ticketbooking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByName(username);
        // CustomUserDetail, UserDetail'den extend olduğu için aynı türde olmuş oluyorlar.
        return new CustomUserDetail(user);
    }
}
