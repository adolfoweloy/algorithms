package com.adolfoeloy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class PascalTriangleTest {

    private PascalTriangle subject = new PascalTriangle();

    @Test
    void testCase1() {
        Assertions
                .assertThat(subject.generate(5))
                .isEqualTo(createList(new int[][]{{1},{1,1},{1,2,1},{1,3,3,1},{1,4,6,4,1}}));
    }

    @Test
    void testCase2() {
        Assertions
                .assertThat(subject.generate(1))
                .isEqualTo(createList(new int[][]{{1}}));
    }

    private List<List<Integer>> createList(int[][] a) {
        List<List<Integer>> r = new ArrayList<>();
        for (int[] row : a) {
            List<Integer> tmp = new ArrayList<>();
            for (int n : row)
                tmp.add(n);
            r.add(tmp);
        }
        return r;
    }
}