package com.softka.fintech.Strategy;

import java.math.BigDecimal;

/**
 * Interfaz de estrategia para el cálculo de comisiones.
 */
public interface CalculadorComisiones {
    /**
     * Calcula la comisión para un monto dado.
     *
     * @param monto monto sobre el que se calcula la comisión
     * @return comisión calculada
     */
    BigDecimal calcular(BigDecimal monto);
}
