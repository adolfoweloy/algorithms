package com.adolfoeloy.dpstudy;

import java.util.HashMap;
import java.util.Map;

public class DeleteAndEarn {
    Map<Integer, Integer> points = new HashMap<>();
    Map<Integer, Integer> memo = new HashMap<>();

    public int deleteAndEarn(int[] nums) {
        // use the max because this way I don't need to worry about deleting (n+1)
        // I am always looking backwards to smaller numbers if starting from max (there's nothing beyond)
        int max = Integer.MIN_VALUE;
        for (int n : nums) {
            if (n > max) max = n;
            points.put(n, points.getOrDefault(n, 0) + 1);
        }
        return dp(max);
    }

    private int dp(int n) {
        if (n == 0) return 0;
        if (n == 1) return points.getOrDefault(1, 0);

        if (!memo.containsKey(n)) {
            memo.put(n, Math.max(
                dp(n - 2) + (n * points.getOrDefault(n, 0)), // if taking, get the points and look for n-2 (n-1 can't be taken now)
                dp(n - 1)
            ));

        }

        return memo.get(n);
    }


}
