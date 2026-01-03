package com.softka.fintech.Repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import com.softka.fintech.Domain.Transaccion;

/**
 * Repositorio reactivo para persistir y consultar entidades `Transaccion`.
 */
public interface TransaccionRepository extends ReactiveCrudRepository<Transaccion, Long> {

}
