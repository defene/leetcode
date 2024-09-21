class Solution {
    public int waysToSplit(int[] nums) {
        int MOD = 1000000007;
        int n = nums.length;
        long[] prefixSum = new long[n];

        prefixSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }

        int count = 0;
        int minMid = 1, maxMid = 1;
        for (int left = 0; left < n - 2; left++) {
            minMid = Math.max(minMid, left + 1);
            while (minMid < n && prefixSum[minMid] - prefixSum[left] < prefixSum[left]) {
                minMid++;
            }
            maxMid = Math.max(maxMid, minMid);
            while (maxMid < n - 1 && prefixSum[maxMid] - prefixSum[left] <= prefixSum[n - 1] - prefixSum[maxMid]) {
                maxMid++;
            }
            if (minMid <= maxMid - 1) {
                count = (count + (maxMid - minMid)) % MOD;
            }
        }

        return count;
    }
}