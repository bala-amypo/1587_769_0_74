package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        // 🔐 JWT Bearer Security Scheme
        SecurityScheme bearerAuth = new SecurityScheme()
                .type(SecurityScheme.Type.HTTP)
                .scheme("bearer")
                .bearerFormat("JWT");

        // 🔒 Apply security globally
        SecurityRequirement securityRequirement =
                new SecurityRequirement().addList("bearerAuth");

        return new OpenAPI()
                .info(new Info()
                        .title("Student Skill Gap API")
                        .version("1.0"))
                // ✅ YOUR SERVER URL (UNCHANGED)
                .servers(List.of(
                        new Server().url("https://9111.pro604cr.amypo.ai")
                ))
                // ✅ ADD JWT SECURITY (THIS ENABLES 🔒)
                .addSecurityItem(securityRequirement)
                .components(new io.swagger.v3.oas.models.Components()
                        .addSecuritySchemes("bearerAuth", bearerAuth));
    }
}
