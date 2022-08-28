package com.adolfoeloy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MatrixReshapeTest {

    private MatrixReshape subject = new MatrixReshape();

    @Test
    void testCase1() {
        int[][] response = subject.matrixReshape(new int[][]{{1, 2}, {3, 4}}, 1, 4);
        Assertions.assertThat(response).isDeepEqualTo(new int[][] {{1,2,3,4}});
    }

}