package com.adolfoeloy.dpstudy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MinCostClimbingStairsTest {

    private final MinCostClimbingStairs subject = new MinCostClimbingStairs();

    @Test
    void testCase1() {
        assertThat(subject.min(new int[] {10,15,20})).isEqualTo(15);
    }

    @Test
    void testCase2() {
        assertThat(subject.min(new int[] {1,100,1,1,1,100,1,1,100,1})).isEqualTo(6);
    }
}
