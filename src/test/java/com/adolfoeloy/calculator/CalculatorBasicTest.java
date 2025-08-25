package com.adolfoeloy.calculator;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class CalculatorBasicTest {
    CalculatorBasic subject = new CalculatorBasic();

    @Test
    void testNullInput() {
        assertThat(subject.calculate(null)).isEqualTo(0);
    }

    @Test
    void testEmptyInput() {
        assertThat(subject.calculate("")).isEqualTo(0);
    }

    @Test
    void testAddition() {
        assertThat(subject.calculate("3+4")).isEqualTo(7);
    }

    @Test
    void testSubtraction() {
        assertThat(subject.calculate("5-4")).isEqualTo(1);
    }

    @Test
    void testAdditionAndSubtraction() {
        assertThat(subject.calculate("1-1+2-2")).isEqualTo(0);
    }

    @Test
    void testWithSpaces() {
        assertThat(subject.calculate(" 3 + 5 ")).isEqualTo(8);
    }

    @Test
    void testSingleNumber() {
        assertThat(subject.calculate("42")).isEqualTo(42);
    }

    @Test
    void testWithParenthesis() {
        assertThat(subject.calculate("(1+(4+5+2)-3)+(6+8)")).isEqualTo(23);
    }

    @Test
    void testEdgeCase() {
        assertThat(subject.calculate("1-(     -2)")).isEqualTo(3);
    }
}