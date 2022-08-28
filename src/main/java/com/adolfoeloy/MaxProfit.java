package com.adolfoeloy;

public class MaxProfit {
    public int maxProfit(int[] prices) {
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
}
