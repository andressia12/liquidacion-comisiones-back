package com.softka.fintech.Domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;

@Table("transacciones")
@Getter
public class Transaccion {

    @Id
    private Long id;
    private BigDecimal monto;
    private BigDecimal comision;
    private LocalDateTime fecha;

    protected Transaccion() {
    }

    public Transaccion(BigDecimal monto, BigDecimal comision, LocalDateTime fecha) {
        this.monto = monto;
        this.comision = comision;
        this.fecha = fecha;
    }
}
