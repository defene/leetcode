class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        
        if (k >= n / 2) {
          return maxProfitUnlimitedTranscations(prices);
        }

        return maxProfitLimitedTranscations(k, prices);
    }

    private int maxProfitUnlimitedTranscations(int[] prices) {
        int n = prices.length;
        int[] hold = new int[n];
        int[] notHold = new int[n];

        hold[0] = -prices[0];
        notHold[0] = 0;

        for (int i = 1; i < n; i++) {
            hold[i] = Math.max(hold[i - 1], notHold[i - 1] - prices[i]);
            notHold[i] = Math.max(notHold[i - 1], hold[i - 1] + prices[i]);
        }

        return notHold[n - 1];
    }

    private int maxProfitLimitedTranscations(int k, int[] prices) {
        int n = prices.length;

        int[] buy = new int[k];
        Arrays.fill(buy, Integer.MAX_VALUE);
        int[] sell = new int[k];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                if (j == 0) {
                    buy[j] = Math.min(buy[j], prices[i]);
                } else {
                    buy[j] = Math.min(buy[j], prices[i] - sell[j - 1]);
                }
                sell[j] = Math.max(sell[j], prices[i] - buy[j]);
            }
        }

        return sell[k - 1];
    }
}