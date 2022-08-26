package com.adolfoeloy;

public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int ans = nums[0];  // ans stands for answer (max subarray)
        int a = ans;        // a is the current subarray sum
        for (int i : nums) {
            int n = nums[i];
            a = Integer.max(n, n + a);
            ans = Integer.max(a, ans);
        }
        return ans;
    }

}
