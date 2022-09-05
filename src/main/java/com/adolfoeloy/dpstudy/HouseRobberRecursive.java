package com.adolfoeloy.dpstudy;

import java.util.HashMap;
import java.util.Map;

public class HouseRobberRecursive {

    public int rob(int[] nums) {
        Map<Integer, Integer> memo = new HashMap<>();
        return dp(memo, nums, nums.length - 1);
    }

    private int dp(Map<Integer, Integer> memo, int[] nums, int idx) {
        if (idx == 0) return nums[0];
        if (idx == 1) return Integer.max(nums[0], nums[1]);

        if (!memo.containsKey(idx))
            memo.put(idx, Integer.max(
                    dp(memo, nums, idx - 1),                    // dp(i - 1)
                    dp(memo, nums, idx - 2) + nums[idx]));      // dp(i - 2) + n[i]

        return memo.get(idx);
    }
}
