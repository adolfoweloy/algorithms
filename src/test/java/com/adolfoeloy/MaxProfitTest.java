package com.adolfoeloy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MaxProfitTest {

    private MaxProfit subject = new MaxProfit();

    @Test
    void testCase1() {
        assertThat(subject.maxProfit(new int[] {7,1,5,3,6,4})).isEqualTo(5);
    }

    @Test
    void testCase2() {
        assertThat(subject.maxProfit(new int[] {7,6,4,3,1})).isEqualTo(0);
    }

    @Test
    void testCase4() {
        assertThat(subject.maxProfit(new int[] {2,4,1})).isEqualTo(2);
    }

    @Test
    void testCase5() {
        assertThat(subject.maxProfit(new int[] {2,1,2,1,0,1,2})).isEqualTo(2);
    }

    @Test
    void testCase6() {
        assertThat(subject.maxProfit(new int[] {1,2,4,2,5,7,2,4,9,0,9})).isEqualTo(9);
    }

}