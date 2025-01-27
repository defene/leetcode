class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int windowLeft = 0;
        int curSum = 0;
        int globalMin = Integer.MAX_VALUE;

        for (int windowRight = 0; windowRight < nums.length; windowRight++) {
            curSum += nums[windowRight];
            while (curSum >= target) {
                int curResult = windowRight - windowLeft + 1;
                if (curResult < globalMin) {
                    globalMin = curResult;
                }
                curSum -= nums[windowLeft];
                windowLeft++;
            }
        }

        return globalMin == Integer.MAX_VALUE ? 0 : globalMin;
    }
}