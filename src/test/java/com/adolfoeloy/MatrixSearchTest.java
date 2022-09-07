package com.adolfoeloy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MatrixSearchTest {

    private final MatrixSearch subject = new MatrixSearch();

    @Test
    void testCase1() {
        int[][] m = new int[][] {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        Assertions.assertThat(subject.searchMatrix(m, 3)).isTrue();
    }
}