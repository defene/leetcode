class Solution {
    public int majorityElement(int[] nums) {
        int count = 1;
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                result = nums[i];
            }
            count += result == nums[i] ? 1 : -1;
        }

        return result;
    }
}