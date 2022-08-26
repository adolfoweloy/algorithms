package com.adolfoeloy;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MaxSubArrayTest {

    @Test
    @DisplayName("should return the element in case there's only one element")
    void testWithOneElement() {
        int[] nums = new int[] {1};
        MaxSubArray msa = new MaxSubArray();
        Assertions.assertThat(msa.maxSubArray(nums)).isEqualTo(1);
    }

    @Test
    @DisplayName("should return the sum of the subarray that produces the largest number")
    void testWithPositiveAndNegativeNumbers() {
        int[] nums = new int[] {-2,1,-3,4,-1,2,1,-5,4};
        MaxSubArray msa = new MaxSubArray();
        Assertions.assertThat(msa.maxSubArray(nums)).isEqualTo(6);
    }

    @Test
    @DisplayName("should return the sum of the subarray that produces the largest number with only one negative number")
    void testWithPositiveAndOneNegative() {
        int[] nums = new int[] {5,4,-1,7,8};
        MaxSubArray msa = new MaxSubArray();
        Assertions.assertThat(msa.maxSubArray(nums)).isEqualTo(23);
    }
}