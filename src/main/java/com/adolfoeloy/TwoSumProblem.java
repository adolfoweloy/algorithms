package com.adolfoeloy;

import java.util.HashMap;
import java.util.Map;

public class TwoSumProblem {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hash = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            Integer x = hash.get(target - curr);
            if (x != null) return new int[] {x, i};
            hash.put(curr, i);
        }

        return null;
    }
}
