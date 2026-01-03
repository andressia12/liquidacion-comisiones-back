package com.softka.fintech.Service;

import java.math.BigDecimal;

import org.h2.mvstore.tx.Transaction;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.softka.fintech.Domain.Transaccion;
import com.softka.fintech.Repository.TransaccionRepository;
import com.softka.fintech.Strategy.CalculadorComisionesGeneral;

import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class TransaccionServiceImplTest {
private TransaccionRepository repository;
    private CalculadorComisionesGeneral calculador;
    private TransaccionService service;

    @BeforeEach
    void setup() {
        repository = Mockito.mock(TransaccionRepository.class);
        calculador = Mockito.mock(CalculadorComisionesGeneral.class);
        service = new TransaccionServiceImpl(repository, calculador);
    }

    @Test
    void shouldCreateTransaccionSuccessfully() {
        BigDecimal monto = BigDecimal.valueOf(12000);
        BigDecimal comision = BigDecimal.valueOf(600);

        Mockito.when(calculador.calcular(monto)).thenReturn(comision);
        Mockito.when(repository.save(Mockito.any(Transaccion.class)))
                .thenAnswer(invocation -> Mono.just(invocation.getArgument(0)));

        StepVerifier.create(service.crear(monto))
                .assertNext(tx -> {
                    assert tx.getMonto().equals(monto);
                    assert tx.getComision().equals(comision);
                })
                .verifyComplete();
    }

    @Test
    void shouldFailWhenAmountIsInvalid() {
        StepVerifier.create(service.crear(BigDecimal.ZERO))
                .verifyError(IllegalArgumentException.class);
    }
}
