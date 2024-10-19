package com.adolfoeloy.dpstudy;

import java.util.Arrays;

public class HouseRobberRecursive {

    public int rob(int[] nums) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return dp(memo, nums, nums.length - 1);
    }

    private int dp(int[] memo, int[] nums, int idx) {
        if (idx == 0) return nums[0];
        if (idx == 1) return Integer.max(nums[0], nums[1]);

        if (memo[idx] == -1)
            memo[idx] = Integer.max(
                    dp(memo, nums, idx - 1),                    // dp(i - 1)
                    dp(memo, nums, idx - 2) + nums[idx]);      // dp(i - 2) + n[i]

        return memo[idx];
    }
}
