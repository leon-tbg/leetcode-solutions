package arrays_hashing.p0122_best_time_to_buy_and_sell_stock_ii;

class Solution {
    public int maxProfit(int[] prices) {
        int sellValue = 0;

        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                sellValue += prices[i + 1] - prices[i];
            }
        }

        return sellValue;
    }
}
