package com.adolfoeloy.arrays;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BestTimeToBuyAndSellTest {
    private final BestTimeToBuyAndSell subject = new BestTimeToBuyAndSell();

    @Test
    void test1() {
        int[] input = new int[] {7,1,5,3,6,4};
        Assertions.assertThat(subject.mySolution(input)).isEqualTo(5);
        Assertions.assertThat(subject.maxProfit(input)).isEqualTo(5);
        Assertions.assertThat(subject.maxProfitWithKadane(input)).isEqualTo(5);
        Assertions.assertThat(subject.maxProfitWithPreprocessing(input)).isEqualTo(5);
    }

    @Test
    void test2() {
        int[] input = new int[] {7,6,4,3,1};
        Assertions.assertThat(subject.mySolution(input)).isEqualTo(0);
        Assertions.assertThat(subject.maxProfit(input)).isEqualTo(0);
        Assertions.assertThat(subject.maxProfitWithKadane(input)).isEqualTo(0);
        Assertions.assertThat(subject.maxProfitWithPreprocessing(input)).isEqualTo(0);
    }

    @Test
    void test3() {
        int[] input = new int[] {2,4,1};
        Assertions.assertThat(subject.mySolution(input)).isEqualTo(2);
        Assertions.assertThat(subject.maxProfit(input)).isEqualTo(2);
        Assertions.assertThat(subject.maxProfitWithKadane(input)).isEqualTo(2);
        Assertions.assertThat(subject.maxProfitWithPreprocessing(input)).isEqualTo(2);
    }

    @Test
    void test4() {
        int[] input = new int[] {2,1,2,1,0,1,2};
        Assertions.assertThat(subject.mySolution(input)).isEqualTo(2);
        Assertions.assertThat(subject.maxProfit(input)).isEqualTo(2);
        Assertions.assertThat(subject.maxProfitWithKadane(input)).isEqualTo(2);
        Assertions.assertThat(subject.maxProfitWithPreprocessing(input)).isEqualTo(2);
    }

    @Test
    void test5() {
        int[] input = new int[] {1,2,4,2,5,7,2,4,9,0,9};
        Assertions.assertThat(subject.mySolution(input)).isEqualTo(9);
        Assertions.assertThat(subject.maxProfit(input)).isEqualTo(9);
        Assertions.assertThat(subject.maxProfitWithKadane(input)).isEqualTo(9);
        Assertions.assertThat(subject.maxProfitWithPreprocessing(input)).isEqualTo(9);
    }

}
