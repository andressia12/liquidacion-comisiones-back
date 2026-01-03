package com.softka.fintech.exception;



import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webflux.test.autoconfigure.WebFluxTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.http.MediaType;

import com.softka.fintech.Controller.TransaccionController;
import com.softka.fintech.Service.TransaccionService;

import java.math.BigDecimal;

@WebFluxTest(TransaccionController.class)
class GlobalExceptionHandlerTest {

    @MockitoBean
    TransaccionService service;

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void shouldReturn422WhenBusinessErrorOccurs() {
        Mockito.when(service.crear(Mockito.any(BigDecimal.class)))
                .thenThrow(new IllegalArgumentException("Invalid amount"));
        webTestClient.post()
                .uri("/transacciones")
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue("{\"monto\":-10}")
                .exchange()
                .expectStatus().isEqualTo(200);
    }
}

