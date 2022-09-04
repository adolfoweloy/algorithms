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
        return _f(n, memo);
    }

    private int _f(int n, int[] memo) {
        if (n == 0 || n == 1) return n;

        if (memo[n] == -1) {
            memo[n] = _f(n-1, memo) + _f(n-2, memo);
        }

        return memo[n];
    }

}
