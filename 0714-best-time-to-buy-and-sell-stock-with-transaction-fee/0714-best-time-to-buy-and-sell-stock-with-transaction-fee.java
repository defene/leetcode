class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[] hold = new int[n];
        int[] notHold = new int[n];

        hold[0] = -prices[0];
        notHold[0] = 0;
        for (int i = 1; i < n; i++) {
            hold[i] = Math.max(hold[i - 1], notHold[i - 1] - prices[i]);
            notHold[i] = Math.max(notHold[i - 1], hold[i - 1] + prices[i] - fee);
        }

        return notHold[n - 1];
    }
}