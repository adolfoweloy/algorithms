package com.adolfoeloy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ValidParenthesesTest {
    private ValidParentheses subject = new ValidParentheses();

    @Test
    void testCase1() {
        assertThat(subject.isValid("()")).isTrue();
    }

    @Test
    void testCase2() {
        assertThat(subject.isValid("()[]{}")).isTrue();
    }

    @Test
    void testCase3() {
        assertThat(subject.isValid("(]")).isFalse();
    }

    @Test
    void testCase4() {
        assertThat(subject.isValid(")]{}")).isFalse();
    }
}