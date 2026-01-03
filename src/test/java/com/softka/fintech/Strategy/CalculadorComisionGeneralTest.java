package com.softka.fintech.Strategy;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.jupiter.api.Test;

public class CalculadorComisionGeneralTest {
    private final CalculadorComisionesGeneral calculador = new CalculadorComisionesGeneral();

    @Test
    void calcularComision_montoMenorOIgualAUmbral_aplicaTasaBaja() {
        BigDecimal monto = BigDecimal.valueOf(5000);
        BigDecimal comisionEsperada = BigDecimal.valueOf(100.00); // 5000 * 0.02
        assertEquals(0, calculador.calcular(monto).compareTo(comisionEsperada));
    }

    @Test
    void calcularComision_montoMayorAUmbral_aplicaTasaAlta() {
        BigDecimal monto = BigDecimal.valueOf(15000);
        BigDecimal comisionEsperada = BigDecimal.valueOf(750.00); // 15000 * 0.05
        assertEquals(0, calculador.calcular(monto).compareTo(comisionEsperada));
    }

    @Test
    void calcularComision_montoEnUmbral_aplicaTasaBaja() {
        BigDecimal monto = BigDecimal.valueOf(10000);
        BigDecimal comisionEsperada = BigDecimal.valueOf(200.00); // 10000 * 0.02
        assertEquals(0, calculador.calcular(monto).compareTo(comisionEsperada));
    }

    @Test
    void calcularComision_montoCero_retornaCero() {
        BigDecimal monto = BigDecimal.ZERO;
        BigDecimal comisionEsperada = BigDecimal.ZERO.setScale(2, RoundingMode.HALF_UP);
        assertEquals(0, calculador.calcular(monto).compareTo(comisionEsperada));
    }

    @Test
    void calcularComision_montoConDecimales_redondeaCorrectamente() {
        BigDecimal monto = BigDecimal.valueOf(12345.67);
        BigDecimal comisionEsperada = BigDecimal.valueOf(617.28);
        assertEquals(0, calculador.calcular(monto).compareTo(comisionEsperada));
    }

}

