package com.softka.fintech.Service;

import java.math.BigDecimal;

import com.softka.fintech.Domain.Transaccion;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TransaccionService {
    Mono<Transaccion> crear(BigDecimal monto);

    Flux<Transaccion> findAll();
}
