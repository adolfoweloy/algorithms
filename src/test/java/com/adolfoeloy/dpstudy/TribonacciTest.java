package com.adolfoeloy.dpstudy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class TribonacciTest {
    private final Tribonacci subject = new Tribonacci();

    @Test
    void testCase1() {
        Assertions.assertThat(subject.tribonacci(4)).isEqualTo(4);
    }

    @Test
    void testCase2() {
        Assertions.assertThat(subject.tribonacci(25)).isEqualTo(1389537);
    }

    @Test
    void testCase3() {
        Assertions.assertThat(subject.tribonacci(0)).isEqualTo(0);
    }
}