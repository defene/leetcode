class Solution {
    public int maxProfit(int[] prices) {
       int n = prices.length;
       int[] maxIfHold = new int[n];
       int[] maxIfNotHold = new int[n];

       maxIfHold[0] = -prices[0];
       maxIfNotHold[0] = 0;
       for (int i = 1; i < n; i++) {
        maxIfHold[i] = Math.max(maxIfHold[i - 1], maxIfNotHold[i - 1] - prices[i]);
        maxIfNotHold[i] = Math.max(maxIfNotHold[i - 1], maxIfHold[i - 1] + prices[i]);
       }

       return maxIfNotHold[n - 1];
    }
}