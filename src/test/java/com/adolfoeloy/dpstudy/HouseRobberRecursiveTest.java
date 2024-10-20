package com.adolfoeloy.dpstudy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class HouseRobberRecursiveTest {
    private final HouseRobberRecursive subject = new HouseRobberRecursive();

    @Test
    void testCase1() {
        assertThat(subject.rob(new int[] {1,2,3,1})).isEqualTo(4);
    }

    @Test
    void testCase2() {
        assertThat(subject.rob(new int[] {2,7,9,3,1})).isEqualTo(12);
    }

    @Test
    void testCase3() {
        assertThat(subject.rob(new int[] {0})).isEqualTo(0);
    }
}