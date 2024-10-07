package com.adolfoeloy.datastructure.heap.application;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class TopKMostFrequentTest {

    private final TopKMostFrequent subject = new TopKMostFrequent();

    @Test
    void test1() {
        int[] result = subject.topKFrequent(new int[] {1,1,1,2,2,3}, 2);

        Assertions.assertThat(result).containsExactly(1, 2);
    }

    @Test
    void test2() {
        int[] result = subject.topKFrequent(new int[] {4,1,-1,2,-1,2,3}, 2);

        Assertions.assertThat(result).containsExactly(2,-1);
    }
}