package com.adolfoeloy.dpstudy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class MaxSubArrayTest {
    private final MaxSubArray subject = new MaxSubArray();

    @Nested
    class MaxSubArraySum {
        @Test
        void test1() {
            Assertions
                    .assertThat(subject.getMaxSum(new int[] {-2,1,-3,4,-1,2,1,-5,4}))
                    .isEqualTo(6);
        }
    }

    @Nested
    class MaxSubArrayList {
        @Test
        void test1() {
            Assertions
                    .assertThat(subject.getMaxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}))
                    .containsExactly(4, -1, 2, 1);
        }
    }
}