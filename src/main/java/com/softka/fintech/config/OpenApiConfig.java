package com.softka.fintech.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI fintechOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Sofka Fintech API")
                        .description("Sistema de Liquidación de Comisiones")
                        .version("1.0.0"));
    }
}

