package com.adolfoeloy.dpstudy;

import java.util.Arrays;

/**
 * This is a problem that can be solved with 2D DP
 * Description:
 * You are given two 0-indexed integer arrays nums and multipliers of size n and m respectively, where n >= m.
 * You begin with a score of 0. You want to perform exactly m operations. On the ith operation (0-indexed) you will:
 * - Choose one integer x from either the start or the end of the array nums.
 * - Add multipliers[i] * x to your score.
 * - Remove x from nums.
 * Then, return the maximum score after performing all m operations.
 */
public class TwoDimensionDP {
    private int[] nums;
    private int[] multipliers;
    private int[][] memo;

    public int maximumScore(int[] nums, int[] multipliers) {
        this.nums = nums;
        this.multipliers = multipliers;

        int n = nums.length;
        int m = multipliers.length;
        this.memo = new int[m][m];
        for (int i=0; i<m; i++) Arrays.fill(memo[i], -1);

        return dp(0, 0, n - 1);
    }

    private int dp(int i, int left, int right) {
        if (i >= memo.length) return 0;

        int scoreLeft = nums[left] * multipliers[i];
        int scoreRight = nums[right] * multipliers[i];

        if (memo[i][left] == -1) {
            memo[i][left] = Math.max(
                    scoreLeft + dp(i + 1, left + 1, right),
                    scoreRight + dp(i + 1, left, right - 1)
            );
        }

        return memo[i][left];
    }

}
