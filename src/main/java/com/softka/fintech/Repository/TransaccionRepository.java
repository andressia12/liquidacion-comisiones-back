package com.softka.fintech.Repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import com.softka.fintech.Domain.Transaccion;

public interface TransaccionRepository extends ReactiveCrudRepository<Transaccion, Long> {

}
