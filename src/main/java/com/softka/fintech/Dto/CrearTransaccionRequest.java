package com.softka.fintech.Dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
/**
 * DTO de entrada para la creación de una transacción.
 */
public class CrearTransaccionRequest {
    /**
     * Monto de la transacción. Debe ser un valor positivo.
     */
    @NotNull
    @Positive
    private BigDecimal monto;

}
