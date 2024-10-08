package com.adolfoeloy.datastructure.heap.application;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class KWeakestRowsTest {
    private final KWeakestRows subject = new KWeakestRows();

    @Test
    void test1() {
        int[][] input = new int[][] {
                {1,1,0,0,0},
                {1,1,1,1,0},
                {1,0,0,0,0},
                {1,1,0,0,0},
                {1,1,1,1,1}
        };

        Assertions
                .assertThat(subject.kWeakestRows(input, 3))
                .containsExactly(2, 0, 3);
    }

    @Test
    void test2() {
        int[][] input = new int[][] {
                {1,0,0,0},
                {1,1,1,1},
                {1,0,0,0},
                {1,0,0,0}
        };

        Assertions
                .assertThat(subject.kWeakestRows(input, 2))
                .containsExactly(0, 2);
    }
}