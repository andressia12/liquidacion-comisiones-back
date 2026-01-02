package com.softka.fintech.Dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class CrearTransaccionRequest {
    @NotNull
    @Positive
    private BigDecimal monto;

    public BigDecimal getMonto() {
        return monto;
    }
}
