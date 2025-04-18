class Solution {
    public int maxProfit(int[] prices) {
        int globalMax = 0;
        int curMin = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > curMin) {
                globalMax = Math.max(globalMax, prices[i] - curMin);
            } else {
                curMin = prices[i];              
            }
        }

        return globalMax;
    }
}