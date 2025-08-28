package com.adolfoeloy.arrays;

public class RotateArray {

    // time complexity: O(N)
    // memory: O(1)
    void solution(int[] nums, int k) {
        var n = nums.length;
        k %= n;

        rotate(nums, 0, n - 1);
        rotate(nums, 0, k - 1);
        rotate(nums, k, n - 1);
    }

    void rotate(int[] nums, int start, int end) {
        while (start < end) {
            var tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }
}
