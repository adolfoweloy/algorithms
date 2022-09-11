package com.adolfoeloy.classic;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BinarySearchTest {

    private final BinarySearch subject = new BinarySearch();

    @Test
    @DisplayName("should return -1 when the number searched does not exist in the array")
    void testCase1() {
        int[] nums = new int[] {1, 2, 3, 20, 90};
        Assertions.assertThat(subject.find(nums, 5)).isEqualTo(-1);
    }

    @Test
    @DisplayName("should return the index of a number that exists in the array")
    void testCase2() {
        int[] nums = new int[] {1, 2, 3, 20, 90};
        Assertions.assertThat(subject.find(nums, 20)).isEqualTo(3);
    }

    @Test
    @DisplayName("should return -1 for number that doesn't exist navigating to the right side")
    void testCase3() {
        int[] nums = new int[] {-1,0,3,5,9,12};
        Assertions.assertThat(subject.find(nums, 13)).isEqualTo(-1);
    }

    @Test
    @DisplayName("should return -1 if the array is empty")
    void testCase5() {
        int[] nums = new int[] {};
        Assertions.assertThat(subject.find(nums, 20)).isEqualTo(-1);
    }
}