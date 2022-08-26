package com.adolfoeloy;

public class MaxSubArray {

    public int maxSubArray(int[] nums) {
        int maxSubArray = Integer.MIN_VALUE;
        for (int i=0; i < nums.length; i++) {
            int currentSubArray = 0;
            for (int j = i; j < nums.length; j++) {
                // adding the number at each iteration and creating comparing it at each iteration
                // is the trick to avoid N^3. With this trick there's no need for a third nested for.
                currentSubArray += nums[j];
                maxSubArray = Integer.max(maxSubArray, currentSubArray);
            }
        }

        return maxSubArray;
    }

}
