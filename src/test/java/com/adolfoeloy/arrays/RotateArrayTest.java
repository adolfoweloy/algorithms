package com.adolfoeloy.arrays;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class RotateArrayTest {

    private final RotateArray rotateArray = new RotateArray();

    @Test
    void shouldRotateArrayByThreeSteps() {
        // Given
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        int[] expected = {5, 6, 7, 1, 2, 3, 4};

        // 7 6 5 4 3 2 1
        // 5 6 7 4 3 2 1
        // 5 6 7 1 2 3 4

        // When
        rotateArray.solution(nums, k);

        // Then
        assertThat(nums).isEqualTo(expected);
    }

    @Test
    void shouldRotateArrayByTwoSteps() {
        // Given
        int[] nums = {-1, -100, 3, 99};
        int k = 2;
        int[] expected = {3, 99, -1, -100};

        // When
        rotateArray.solution(nums, k);

        // Then
        assertThat(nums).isEqualTo(expected);
    }

    @Test
    void shouldHandleRotationGreaterThanArrayLength() {
        // Given
        int[] nums = {1, 2, 3, 4, 5};
        int k = 7; // k > nums.length
        int[] expected = {4, 5, 1, 2, 3}; // equivalent to k = 2

        // When
        rotateArray.solution(nums, k);

        // Then
        assertThat(nums).isEqualTo(expected);
    }

    @Test
    void shouldHandleZeroRotation() {
        // Given
        int[] nums = {1, 2, 3, 4, 5};
        int k = 0;
        int[] expected = {1, 2, 3, 4, 5}; // no change

        // When
        rotateArray.solution(nums, k);

        // Then
        assertThat(nums).isEqualTo(expected);
    }

    @Test
    void shouldHandleSingleElementArray() {
        // Given
        int[] nums = {42};
        int k = 5;
        int[] expected = {42}; // single element doesn't change

        // When
        rotateArray.solution(nums, k);

        // Then
        assertThat(nums).isEqualTo(expected);
    }

    @Test
    void shouldHandleTwoElementArray() {
        // Given
        int[] nums = {1, 2};
        int k = 1;
        int[] expected = {2, 1};

        // When
        rotateArray.solution(nums, k);

        // Then
        assertThat(nums).isEqualTo(expected);
    }

    @Test
    void shouldHandleFullRotation() {
        // Given
        int[] nums = {1, 2, 3, 4};
        int k = 4; // k equals array length
        int[] expected = {1, 2, 3, 4}; // full rotation returns to original

        // When
        rotateArray.solution(nums, k);

        // Then
        assertThat(nums).isEqualTo(expected);
    }

    @Test
    void shouldHandleNegativeNumbers() {
        // Given
        int[] nums = {-5, -3, -1, 0, 2, 4};
        int k = 2;
        int[] expected = {2, 4, -5, -3, -1, 0};

        // When
        rotateArray.solution(nums, k);

        // Then
        assertThat(nums).isEqualTo(expected);
    }

    @Test
    void shouldHandleLargeRotationValue() {
        // Given
        int[] nums = {1, 2};
        int k = 99; // very large k
        int[] expected = {2, 1}; // k % 2 = 1

        // When
        rotateArray.solution(nums, k);

        // Then
        assertThat(nums).isEqualTo(expected);
    }
}
