class Solution {
    public int removeDuplicates(int[] nums) {
        int size = nums.length;
        int i = 1;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] == nums[j - 1]) {
                size--;
                continue;
            }
            nums[i++] = nums[j];
        }

        return size;
    }
}