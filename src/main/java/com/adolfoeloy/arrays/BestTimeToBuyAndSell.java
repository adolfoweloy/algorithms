package com.adolfoeloy.arrays;

/**
 * This is the best time to buy and sell problem from Leetcode.
 * The name of the problem is deceiving here because the goal is to find the maximum profit
 * that can be obtained from an array of stock prices.
 *
 * Leetcode mentions DP as a topic related to this problem and that is also deceiving.
 * The algorithms used here are not DP. Although they can be solved with recursion,
 * there are NO overlapping sub-problems and that is one of the key characteristics
 */
public class BestTimeToBuyAndSell {

    /**
     * That was my own solution (of course someone else have already done this).
     * In hindsight, I find interesting here that I thought of a way to keep track of valleys with two pointers i and j.
     * This can be easier to understand than Kadane's variations, but it's a bit more verbose.
     */
    public int mySolution(int[] prices) {
        int maxPrice=0;
        for (int i = 0, j = 1; j < prices.length; j++) {
            if (prices[i] < prices[j]) {
                maxPrice = Integer.max(maxPrice, prices[j] - prices[i]);
            } else {
                i=j;
            }
        }
        return maxPrice;
    }

    /**
     * This algorithm preprocesses the input in order to obtain positive and negative values
     * that will determine when the profit goes up or down respectively.
     * With this preprocessed array, it's possible to apply the classic implementation
     * of Kadane's algorithm without any changes, i.e. the very same algorithm used
     * to find the maximum sub-array sum can also be used to compute the max profit here.
     *
     * The only problem with this approach is that it is less efficient if just using
     * a variation of Kadane's algorithm because it computes the max profit on two passes
     * instead of only one.
     */
    public int maxProfitWithPreprocessing(int[] prices) {
        // pre-processing the array allows me to further use Kadane's algorithm
        // to find the maximum sub-array sum which will be the max profit.
        for (int i=0; i<prices.length; i++) {
            int sellPrice = (i+1 == prices.length) ? 0 : prices[i+1];
            prices[i] = sellPrice - prices[i];
        }

        // this is pure Kadane's algorithm.
        int curr = prices[0];
        int max = prices[0];
        for (int i = 1; i < prices.length; i++) {
            int n = prices[i];
            curr = Math.max(n + curr, n);
            max = Math.max(curr, max);
        }

        return Math.max(max, 0);
    }

    /**
     * This algorithm uses Kadane's variation. The variation here is minimal because
     * instead of having the local sub-array to keep the values that lead to the maximum value,
     * there is no actual local sub-array, but only a variable used to keep track of the minimum price.
     * The second statement within the loop looks more similar to how the max sub-array is computed though.
     */
    public int maxProfitWithKadane(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int p: prices) {
            minPrice = Math.min(minPrice, p);
            maxProfit = Math.max(maxProfit, p-minPrice);
        }
        return maxProfit;
    }

    /**
     * This is the solution from Leetcode.
     * The time complexity is the same as {@code this#maxProfitWithKadane}.
     * However, I think that this algorithm can be slightly confusing and harder to grasp.
     * It brings a different approach where min price and max profit are computed separately at
     * different times when iterating over all prices. This is different of how {@code maxProfitWithKadane}
     * does because the latter computes both values at the same iteration step. That way I don't
     * have to think how the algorithm works at different steps that happen accordingly to the
     * present conditions. I don't want not because of taste, but because it's just harder.
     */
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int p : prices) {
            if (p < minPrice) minPrice = p;
            else if (p - minPrice > maxProfit) maxProfit = p - minPrice;
        }
        return maxProfit;
    }

}
