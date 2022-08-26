package com.adolfoeloy;

public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];

        int max = Integer.MIN_VALUE;
        for (int k=0; k < nums.length; k++) {
            for (int i=k; i < nums.length; i++) {
                int sum=0;
                for (int j=k; j<=i; j++) {
                    sum+=nums[j];
                }
                max = Integer.max(max, sum);
            }
        }

        return max;
    }

}
