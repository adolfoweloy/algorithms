package com.adolfoeloy.calculator;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class CalculatorBasicBasicTest {

    @Test
    void testNullInput() {
        CalculatorBasic calculatorBasic = new CalculatorBasic();
        assertThat(calculatorBasic.calculate(null)).isEqualTo(0);
    }

    @Test
    void testEmptyInput() {
        CalculatorBasic calculatorBasic = new CalculatorBasic();
        assertThat(calculatorBasic.calculate("")).isEqualTo(0);
    }

    @Test
    void testAddition() {
        CalculatorBasic calculatorBasic = new CalculatorBasic();
        assertThat(calculatorBasic.calculate("3+4")).isEqualTo(7);
    }

    @Test
    void testSubtraction() {
        CalculatorBasic calculatorBasic = new CalculatorBasic();
        assertThat(calculatorBasic.calculate("5-4")).isEqualTo(1);
    }

    @Test
    void testMultiplication() {
        CalculatorBasic calculatorBasic = new CalculatorBasic();
        assertThat(calculatorBasic.calculate("4*5")).isEqualTo(20);
    }

    @Test
    void testDivision() {
        CalculatorBasic calculatorBasic = new CalculatorBasic();
        assertThat(calculatorBasic.calculate("8/4")).isEqualTo(2);
    }

    @Test
    void testMixedOperations() {
        CalculatorBasic calculatorBasic = new CalculatorBasic();
        assertThat(calculatorBasic.calculate("3+4*2/2-1")).isEqualTo(6);
    }

    @Test
    void testWithSpaces() {
        CalculatorBasic calculatorBasic = new CalculatorBasic();
        assertThat(calculatorBasic.calculate(" 3 + 5 * 4 ")).isEqualTo(23);
    }

    @Test
    void testComplexExpression() {
        CalculatorBasic calculatorBasic = new CalculatorBasic();
        assertThat(calculatorBasic.calculate("1-1+2-2")).isEqualTo(0);
    }
}