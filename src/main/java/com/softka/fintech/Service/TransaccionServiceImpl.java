package com.softka.fintech.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.softka.fintech.Domain.Transaccion;
import com.softka.fintech.Repository.TransaccionRepository;
import com.softka.fintech.Strategy.CalculadorComisiones;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Implementación del servicio de transacciones.
 * Encapsula la validación del monto y la creación de la entidad.
 */
@Service
public class TransaccionServiceImpl implements TransaccionService {

    private final TransaccionRepository repository;
    private final CalculadorComisiones calculadorComisiones;

    public TransaccionServiceImpl(
            TransaccionRepository repository,
            CalculadorComisiones calculadorComisiones) {
        this.repository = repository;
        this.calculadorComisiones = calculadorComisiones;
    }

    @Override
    public Mono<Transaccion> crear(BigDecimal monto) {
        return validarMonto(monto)
                .map(montoValido -> {
                    var comision = calculadorComisiones.calcular(montoValido);
                    return new Transaccion(
                            montoValido,
                            comision,
                            LocalDateTime.now());
                })
                .flatMap(repository::save);
    }

    @Override
    public Flux<Transaccion> findAll() {
        return repository.findAll();
    }

    /**
     * Valida que el monto sea mayor que cero.
     *
     * @param monto monto a validar
     * @return Mono con el mismo monto si es válido o error si no lo es
     */
    private Mono<BigDecimal> validarMonto(BigDecimal monto) {
        if (monto == null || monto.signum() <= 0) {
            return Mono.error(new IllegalArgumentException("El monto debe ser mayor que cero."));
        }
        return Mono.just(monto);
    }
}
