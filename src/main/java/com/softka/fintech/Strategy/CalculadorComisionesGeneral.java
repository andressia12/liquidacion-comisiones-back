package com.softka.fintech.Strategy;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.springframework.stereotype.Component;

@Component
public class CalculadorComisionesGeneral implements CalculadorComisiones {
    private static final BigDecimal UMBRAL_MAXIMO = BigDecimal.valueOf(10_000);
    private static final BigDecimal TASA_ALTA = BigDecimal.valueOf(0.05);
    private static final BigDecimal TASA_BAJA = BigDecimal.valueOf(0.02);

    @Override
    public BigDecimal calcular(BigDecimal monto) {
        BigDecimal tasa = monto.compareTo(UMBRAL_MAXIMO) > 0
                ? TASA_ALTA
                : TASA_BAJA;

        return monto
                .multiply(tasa)
                .setScale(2, RoundingMode.HALF_UP);
    }
}
