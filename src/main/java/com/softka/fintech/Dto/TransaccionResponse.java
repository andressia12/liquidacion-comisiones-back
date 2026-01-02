package com.softka.fintech.Dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransaccionResponse {

    private final Long id;
    private final BigDecimal monto;
    private final BigDecimal comision;
    private final LocalDateTime fecha;

    public TransaccionResponse(
            Long id,
            BigDecimal monto,
            BigDecimal comision,
            LocalDateTime fecha) {
        this.id = id;
        this.monto = monto;
        this.comision = comision;
        this.fecha = fecha;
    }
}
