package com.adolfoeloy.datastructure.heap.application;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class KthLargestTest {

    @Test
    void test1() {
        var subject = new KthLargest(3, new int[] {4, 5, 8, 2});

        Assertions.assertThat(subject.add(3)).isEqualTo(4);
        Assertions.assertThat(subject.add(5)).isEqualTo(5);
        Assertions.assertThat(subject.add(10)).isEqualTo(5);
        Assertions.assertThat(subject.add(9)).isEqualTo(8);
        Assertions.assertThat(subject.add(4)).isEqualTo(8);
    }
}