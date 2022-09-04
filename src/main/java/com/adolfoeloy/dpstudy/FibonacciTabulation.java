package com.adolfoeloy.dpstudy;

/**
 * Tabulation uses bottom-up approach building up the solution iteratively from the base case.
 * Complexity O(N) - a recursive solution without tabulation could lead to exponential complexity.
 */
public class FibonacciTabulation {

    public int f(int n) {
        int[] fib = new int[n + 2];
        fib[0] = 0;
        fib[1] = 1;

        for (int i=2; i<=n; i++) {
            fib[i] = fib[i-1] + fib[i-2];
        }

        return fib[n];
    }

}
