package com.softka.fintech.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softka.fintech.Dto.CrearTransaccionRequest;
import com.softka.fintech.Dto.TransaccionResponse;
import com.softka.fintech.Service.TransaccionService;

import jakarta.validation.Valid;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * REST controller que expone los endpoints para manejar transacciones.
 * <p>
 * Endpoints:
 * - POST /transacciones : crea una nueva transacción.
 * - GET  /transacciones : obtiene todas las transacciones.
 */
@RestController
@RequestMapping("/transacciones")
public class TransaccionController {
    private final TransaccionService service;

    public TransaccionController(TransaccionService service) {
        this.service = service;
    }

        /**
         * Crea una nueva transacción a partir del request recibido.
         *
         * @param request Mono con el cuerpo validado que contiene el monto
         * @return Mono con la respuesta de la transacción creada
         */
        @PostMapping
        public Mono<TransaccionResponse> crear(
            @Valid @RequestBody Mono<CrearTransaccionRequest> request) {
        return request
                .flatMap(req -> service.crear(req.getMonto()))
                .map(tx -> new TransaccionResponse(
                        tx.getId(),
                        tx.getMonto(),
                        tx.getComision(),
                        tx.getFecha()));
    }

    /**
     * Devuelve todas las transacciones almacenadas.
     *
     * @return Flux con las transacciones en formato de respuesta
     */
    @GetMapping
    public Flux<TransaccionResponse> findAll() {
        return service.findAll()
                .map(tx -> new TransaccionResponse(
                        tx.getId(),
                        tx.getMonto(),
                        tx.getComision(),
                        tx.getFecha()));
    }
}
