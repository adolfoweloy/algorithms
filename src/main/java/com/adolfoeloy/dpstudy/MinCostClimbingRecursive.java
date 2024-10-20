package com.adolfoeloy.dpstudy;

import java.util.Arrays;

public class MinCostClimbingRecursive {
    private int[] stairs;
    private int[] memo;

    public int min(int[] costs) {
        int n = costs.length;
        stairs = Arrays.copyOf(costs, n + 1);
        memo = new int[n + 1];
        Arrays.fill(memo, -1);

        return dp(n);
    }

    private int dp(int i) {
        if (i == 0) return stairs[0];
        if (i == 1) return stairs[1];

        if (memo[i] == -1) {
            memo[i] = Math.min(
                dp(i - 1) + stairs[i],
                dp(i - 2) + stairs[i]
            );
        }

        return memo[i];
    }
}
