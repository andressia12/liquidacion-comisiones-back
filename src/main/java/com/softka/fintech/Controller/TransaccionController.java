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

@RestController
@RequestMapping("/transacciones")
public class TransaccionController {
    private final TransaccionService service;

    public TransaccionController(TransaccionService service) {
        this.service = service;
    }

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
