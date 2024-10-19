package com.adolfoeloy.dpstudy;

import java.util.Arrays;

/**
 * This is the classic example of Kadane's algorithm.
 * This algorithm was created to find the maximum sub-array sum on a one-dimensional array,
 * and it turns out that it can be used to solve other problems such
 * as the "Best time to buy and sell stocks" problem. If an array is composed of positive integers only,
 * the algorithm is not necessary since the sum is the sum of the whole array.
 * The algorithm makes sense when there's negative and positive numbers in the array
 * which is not actually the case when solving the "best time to buy and sell stocks".
 */
public class MaxSubArray {

    public int getMaxSum(int[] nums) {
        int curr = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int n = nums[i];
            curr = Math.max(n, n + curr);
            max = Math.max(max, curr);
        }
        return max;
    }

    public int[] getMaxSubArray(int[] nums) {
        int currSum = nums[0];
        int currMax = nums[0];

        int s = 0; // start
        int e = 1; // end

        for (int i = 1; i < nums.length; i++) {
            int n = nums[i];

            // updating local max
            if ((n + currSum) < n) {
                currSum = n;
                s = i;
            } else {
                currSum += n;
            }

            // updating global max
            if (currSum > currMax) {
                e = i + 1;
                currMax = currSum;
            }
        }

        return Arrays.copyOfRange(nums, s, e);
    }
}
