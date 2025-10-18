package com.example.Orion.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/h2-console/**").permitAll() // libera o H2 console
                        .anyRequest().permitAll() // libera tudo (apenas enquanto desenvolve)
                )
                .headers(headers -> headers.frameOptions(frame -> frame.disable())); // necessário pro H2

        return http.build();
    }
}