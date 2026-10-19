package sliding_window.p0121_best_time_to_buy_and_sell_stock;

class Solution {
    public int maxProfit(int[] prices) {
        int left = 0;
        int max = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[left] > prices[i]) {
                left = i;
            }
            if (prices[i] - prices[left] > max) {
                max = prices[i] - prices[left];
            }
        }

        return max;
    }
}
