class Solution {
    public int lastStoneWeightII(int[] stones) {
        int weight = 0;
        for (int stone : stones) {
            weight += stone;
        }

        int n = stones.length;
        int[][] dp = new int[n + 1][weight / 2 + 1];
        
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= weight / 2; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= stones[i - 1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - stones[i - 1]] + stones[i - 1]);
                }
            }
        }

        return weight - 2 * dp[n][weight / 2];
    }
}