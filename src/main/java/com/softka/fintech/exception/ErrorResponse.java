package com.softka.fintech.exception;

import java.time.LocalDateTime;

import lombok.Getter;

@Getter
public class ErrorResponse {
    private final String message;
    private final int status;
    private final LocalDateTime timestamp;

    /**
     * Response estándar para errores de la API.
     *
     * @param message mensaje de error legible
     * @param status  código HTTP asociado al error
     */
    public ErrorResponse(String message, int status) {
        this.message = message;
        this.status = status;
        this.timestamp = LocalDateTime.now();
    }
}
