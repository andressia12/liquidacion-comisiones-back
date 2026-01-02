package com.softka.fintech.Dto;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrearTransaccionRequest {
    @NotNull
    @Positive
    private BigDecimal monto;

}
