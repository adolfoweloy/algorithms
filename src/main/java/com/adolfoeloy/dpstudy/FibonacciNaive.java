package com.adolfoeloy.dpstudy;

/**
 * Implementing fibonacci is intuitively a recursive operation where
 * F(N) = F(N-1) + F(N-2). This naive approach will compute some values unnecessarily.
 */
public class FibonacciNaive {

    public int f(int n) {
        if (n == 0 || n == 1) return n;

        return f(n-1) + f(n-2);
    }
}
