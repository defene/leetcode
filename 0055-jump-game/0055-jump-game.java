class Solution {
    public boolean canJump(int[] nums) {
        int curMax = 0;
        int curEnd = 0;
        
        for (int i = 0; i < nums.length; i++) {
            curMax = Math.max(curMax, i + nums[i]);

            if (i == curEnd) {
                curEnd = curMax;
            }
        }

        return curEnd >= nums.length - 1;
    }
}