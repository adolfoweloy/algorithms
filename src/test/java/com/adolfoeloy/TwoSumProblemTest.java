package com.adolfoeloy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TwoSumProblemTest {

    private TwoSumProblem subject = new TwoSumProblem();

    @Test
    public void testCase1() {
        assertThat(subject.twoSum(new int[] {2, 7, 11, 15}, 9)).isEqualTo(new int[]{0, 1});
    }

    @Test
    public void testCase2() {
        assertThat(subject.twoSum(new int[] {3,2,4}, 6)).isEqualTo(new int[]{1, 2});
    }

    @Test
    public void testCase3() {
        assertThat(subject.twoSum(new int[] {3,3}, 6)).isEqualTo(new int[]{0, 1});
    }
}