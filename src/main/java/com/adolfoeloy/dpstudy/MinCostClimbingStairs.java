package com.adolfoeloy.dpstudy;

public class MinCostClimbingStairs {
    public int min(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1]; // n+1 is the top floor
        dp[0] = 0; dp[1] = 0;      // to reach step 0 or 1 the cost is 0 (the count of the step itself doesn't count)

        for (int i=2; i<=n; i++) {
            dp[i] = Integer.min(cost[i-1] + dp[i-1], cost[i-2] + dp[i-2]);
        }

        return dp[n];
    }
}
