package com.softka.fintech.Controller;


import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.http.MediaType;

import com.softka.fintech.Domain.Transaccion;
import com.softka.fintech.Service.TransaccionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webflux.test.autoconfigure.WebFluxTest;

import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@WebFluxTest(TransaccionController.class)
class TransaccionControllerTest {

    @Autowired
    private WebTestClient webTestClient;

        @MockitoBean
        private TransaccionService service;

    @Test
    void shouldCreateTransaction() {
        Transaccion tx = new Transaccion(
                BigDecimal.valueOf(10000),
                BigDecimal.valueOf(200),
                LocalDateTime.now()
        );

        Mockito.when(service.crear(Mockito.any()))
                .thenReturn(Mono.just(tx));

        webTestClient.post()
            .uri("/transacciones")
            .contentType(MediaType.APPLICATION_JSON)
            .bodyValue("{\"monto\":10000}")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.comision").isEqualTo(200);
    }
}

