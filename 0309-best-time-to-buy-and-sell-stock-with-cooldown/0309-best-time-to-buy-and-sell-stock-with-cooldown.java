class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }
        
        int n = prices.length;
        int[] hold = new int[n];
        int[] notHold = new int[n];

        hold[0] = -prices[0];
        notHold[0] = 0;

        hold[1] = Math.max(hold[0], -prices[1]);
        notHold[1] = Math.max(notHold[0], prices[1] + hold[0]);
        for (int i = 2; i < n; i++) {
            hold[i] = Math.max(hold[i - 1], notHold[i - 2] - prices[i]);
            notHold[i] = Math.max(notHold[i - 1], hold[i - 1] + prices[i]);
        }

        return notHold[n - 1];
    }
}