package com.mcan.ticketbooking.core.component;

import com.mcan.ticketbooking.model.Role;
import com.mcan.ticketbooking.model.User;
import com.mcan.ticketbooking.repository.RoleRepository;
import com.mcan.ticketbooking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserAndRoleSeeder implements ApplicationRunner {
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;


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
                .name("mcanadmin")
                .email("mcan@g.com")
                .password(passwordEncoder.encode("12345678"))
                .roles(adminRoleList).build();
        userRepository.save(admin);

        User user = User.builder().id(2L)
                .name("usercan")
                .email("user@g.com")
                .password(passwordEncoder.encode("12345678"))
                .roles(userRoleList).build();
        userRepository.save(user);


    }
}
