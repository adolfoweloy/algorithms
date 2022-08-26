package com.adolfoeloy;

public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int currentSubarray = nums[0];
        int maxSubArray = nums[0];
        for (int i=1; i<nums.length; i++) {
            currentSubarray = (currentSubarray < 0) ? nums[i] : currentSubarray + nums[i];
            maxSubArray = Integer.max(currentSubarray, maxSubArray);
        }
        return maxSubArray;
    }

}
