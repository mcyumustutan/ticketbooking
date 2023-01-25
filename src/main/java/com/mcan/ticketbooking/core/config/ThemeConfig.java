package com.mcan.ticketbooking.core.config;

import nz.net.ultraq.thymeleaf.layoutdialect.LayoutDialect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ThemeConfig {
    @Bean
    public LayoutDialect layoutDialect() {

        return new LayoutDialect();
    }

}
