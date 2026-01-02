package com.softka.fintech.Strategy;

import java.math.BigDecimal;

public interface CalculadorComisiones {
    BigDecimal calcular(BigDecimal monto);
}
