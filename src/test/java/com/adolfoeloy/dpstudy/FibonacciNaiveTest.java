package com.adolfoeloy.dpstudy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FibonacciNaiveTest {
    private final FibonacciNaive subject = new FibonacciNaive();

    @Test
    @DisplayName("should return 0 for F(0) - base case")
    void testCase1() {
        assertThat(subject.f(0)).isEqualTo(0);
    }

    @Test
    @DisplayName("should return 1 for F(1) - base case")
    void testCase2() {
        assertThat(subject.f(1)).isEqualTo(1);
    }

    @Test
    @DisplayName("should return 1 for F(2) = F(1) + F(0)")
    void testCase3() {
        assertThat(subject.f(2)).isEqualTo(1);
    }

    @Test
    @DisplayName("should return 3 for F(4) is generated from 0 1 1 2 3")
    void testCase4() {
        assertThat(subject.f(4)).isEqualTo(3);
    }

    @Test
    @DisplayName("should return 8 for F(6) is generated from 0 1 1 2 3 5 8")
    void testCase5() {
        assertThat(subject.f(6)).isEqualTo(8);
    }

    @Test
    @DisplayName("f(42) should take more than a second (slow)")
    void testCase6() {
        long start = System.currentTimeMillis();
        int answer = subject.f(42);
        long elapsedTime = System.currentTimeMillis() - start;

        assertThat(answer).isEqualTo(267914296);
        assertThat(elapsedTime).isGreaterThan(1000);
    }
}