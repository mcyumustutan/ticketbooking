package com.mcan.ticketbooking.core.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Autowired
    AuthenticationSuccessHandler successHandler;

    @Bean
    PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authorizeRequests()

                .antMatchers("/").permitAll()
                .antMatchers("/home").permitAll()
                .antMatchers("/simple").permitAll()

                .antMatchers("/client").hasRole("USER")
                .antMatchers("/admin").hasRole("ADMIN")

                .anyRequest()
                .authenticated()

                .and()
                .headers().frameOptions().sameOrigin()

                .and()
                .formLogin()
                .successHandler(successHandler)
                .and()

                .build();
    }
}