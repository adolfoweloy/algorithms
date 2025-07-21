package com.adolfoeloy.calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorWithParenthesesTest {

    private final CalculatorWithParentheses subject = new CalculatorWithParentheses();

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
    void testMultiplication() {
        assertThat(subject.calculate("4*5")).isEqualTo(20);
    }

    @Test
    void testDivision() {
        assertThat(subject.calculate("8/4")).isEqualTo(2);
    }

    @Test
    void testMixedOperations() {
        assertThat(subject.calculate("3+4*2/2-1")).isEqualTo(6);
    }

    @Test
    void testWithSpaces() {
        assertThat(subject.calculate(" 3 + 5 * 4 ")).isEqualTo(23);
    }

    @Test
    void testComplexExpression() {
        assertThat(subject.calculate("1-1+2-2")).isEqualTo(0);
    }

    @Test
    void testParentheses() {
        assertThat(subject.calculate("(1+(4+5+2)-3)+(6+8)")).isEqualTo(23);
    }

    @Test
    void testNestedParentheses() {
        assertThat(subject.calculate("((1+2)*3+(4*5))")).isEqualTo(29);
    }

    @Test
    void testEdgeCase1() {
        assertThat(subject.calculate("1+(2/2+3)")).isEqualTo(5);
    }

    @Test
    void testDivisionWithNegativeResultInParentheses() {
        assertThat(subject.calculate("3/(2/1-4)")).isEqualTo(-1);
    }

    @Test
    void testSimpleParentheses() {
        assertThat(subject.calculate("(2+3)")).isEqualTo(5);
    }


}