package com.softka.fintech.Dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Getter;

@Getter
public class TransaccionResponse {

    private final Long id;
    private final BigDecimal monto;
    private final BigDecimal commision;
    private final LocalDateTime fecha;

    public TransaccionResponse(
            Long id,
            BigDecimal monto,
            BigDecimal commision,
            LocalDateTime fecha) {
        this.id = id;
        this.monto = monto;
        this.commision = commision;
        this.fecha = fecha;
    }
}
