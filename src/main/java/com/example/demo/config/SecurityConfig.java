package com.example.demo.config;

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

                // ✅ Allow Swagger UI
                .requestMatchers(
                        "/swagger-ui/**",
                        "/swagger-ui.html",
                        "/v3/api-docs/**",
                        "/v3/api-docs.yaml",
                        "/swagger-resources/**",
                        "/webjars/**"
                ).permitAll()

                // ✅ Allow Public Auth APIs
                .requestMatchers(
                        "/api/auth/login",
                        "/api/auth/register",
                        "/api/auth/users",
                        "/api/auth/user/**"
                ).permitAll()

                // 🔐 Everything else is secured
                .anyRequest().authenticated()
            );

        return http.build();
    }
}
