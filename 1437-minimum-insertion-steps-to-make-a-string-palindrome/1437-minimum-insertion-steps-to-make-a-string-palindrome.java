class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        char[] array = s.toCharArray();

        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;  
            for (int j = i + 1; j < n; j++) {  
                if (array[i] == array[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return s.length() - dp[0][n - 1];
    }
}