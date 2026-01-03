package com.softka.fintech.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;

import reactor.core.publisher.Mono;

/**
 * Manejador global de excepciones para los controladores web.
 * Convierte excepciones en objetos `ErrorResponse` adecuados para el cliente.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(WebExchangeBindException.class)
    public Mono<ErrorResponse> handleValidationError(WebExchangeBindException ex) {
        String message = ex.getFieldErrors()
                .stream()
                .findFirst()
                .map(error -> error.getField() + " " + error.getDefaultMessage())
                .orElse("Error de validación");

        return Mono.just(new ErrorResponse(message, HttpStatus.BAD_REQUEST.value()));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public Mono<ErrorResponse> handleBusinessError(IllegalArgumentException ex) {
        return Mono.just(
                new ErrorResponse(ex.getMessage(), HttpStatusCode.valueOf(422).value()));
    }

    @ExceptionHandler(Exception.class)
    public Mono<ErrorResponse> handleGenericError(Exception ex) {
        return Mono.just(
                new ErrorResponse("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR.value()));
    }
}
