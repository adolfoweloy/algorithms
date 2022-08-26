package com.adolfoeloy;

import java.util.HashMap;
import java.util.Map;

public class TwoSumProblem {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hash = new HashMap<>();

        for (int i=0; i<nums.length; i++) {
            hash.put(nums[i], i);
        }

        for (int i=0; i<nums.length; i++) {
            int value = nums[i];
            int complement = target - value;
            if (hash.containsKey(complement)) {
                if (hash.get(complement) == i) continue;
                return new int[] {i, hash.get(complement)};
            }
        }

        return null;
    }
}
