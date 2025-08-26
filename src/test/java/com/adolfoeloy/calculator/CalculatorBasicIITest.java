package com.adolfoeloy.calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorBasicIITest {

    private final CalculatorBasicII subject = new CalculatorBasicII();

    @Test
    void testCaseSumAndMultiplication() {
        assertThat(subject.calculate("3+2*2")).isEqualTo(7);
    }

    @Test
    void testDivision() {
        assertThat(subject.calculate("3/2")).isEqualTo(1);
    }

    @Test
    void testCaseSumAndDivision() {
        assertThat(subject.calculate(" 3+5 / 2 ")).isEqualTo(5);
    }
}