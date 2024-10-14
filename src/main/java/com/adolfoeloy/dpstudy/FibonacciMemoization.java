package com.adolfoeloy.dpstudy;

import java.util.Arrays;

/**
 * This is the fibonacci algorithm using recursive approach but memoizing to avoid computing
 * values already computed.
 */
public class FibonacciMemoization {
    public int f(int n) {
        int[] memo = new int[n+1];
        Arrays.fill(memo, -1);
        return _f(memo, n);
    }

    private int _f(int[] memo, int n) {
        if (n < 2) return n;
        if (memo[n] == -1) {
            memo[n] = _f(memo, n-2) + _f(memo, n-1);
        }
        return memo[n];
    }
}
