package com.adolfoeloy;

public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int a = 0;
        for (int n : nums) {
            a = Integer.max(n, n + a);
            ans = Integer.max(a, ans);
        }
        return ans;
    }

}
