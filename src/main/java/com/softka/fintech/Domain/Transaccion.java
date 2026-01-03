package com.softka.fintech.Domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Getter;
import lombok.Setter;

/**
 * Representa una transacción financiera persistida en la tabla "transacciones".
 */
@Table("TRANSACCIONES")
@Getter
@Setter
public class Transaccion {

    @Id
    private Long id;
    private BigDecimal monto;
    private BigDecimal comision;
    private LocalDateTime fecha;

    protected Transaccion() {
    }

    /**
     * Constructor usado para crear una transacción nueva antes de persistirla.
     *
     * @param monto    monto de la transacción
     * @param comision comisión calculada para la transacción
     * @param fecha    fecha y hora de creación
     */
    public Transaccion(BigDecimal monto, BigDecimal comision, LocalDateTime fecha) {
        this.monto = monto;
        this.comision = comision;
        this.fecha = fecha;
    }
}
