package com.softka.fintech.Service;

import java.math.BigDecimal;

import com.softka.fintech.Domain.Transaccion;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Servicio para gestionar la lógica de negocio de transacciones.
 */
public interface TransaccionService {
    /**
     * Crea una nueva transacción calculando la comisión correspondiente.
     *
     * @param monto Monto de la transacción
     * @return Mono con la transacción creada
     */
    Mono<Transaccion> crear(BigDecimal monto);

    /**
     * Obtiene todas las transacciones existentes.
     *
     * @return Flux con las transacciones
     */
    Flux<Transaccion> findAll();
}
