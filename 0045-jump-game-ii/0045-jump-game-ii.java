class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[n - 1] = 0;

        for (int i = 0; i < n - 1; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int i = n - 2; i >= 0; i--) {
            if (i + nums[i] >= n - 1) {
                dp[i] = 1;
                continue;
            }
            
            for (int j = i + 1; j <= i + nums[i]; j++) {
                dp[i] = Math.min(dp[j], dp[i]);
            }
            if (dp[i] != Integer.MAX_VALUE) dp[i]++;
        }

        return dp[0];
    }
}