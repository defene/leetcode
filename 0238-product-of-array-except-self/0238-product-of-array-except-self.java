class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        int prev = nums[n - 1];
        nums[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            int temp = nums[i];
            nums[i] = nums[i + 1] * prev;
            prev = temp;
        }

        for (int i = 0; i < n; i++) {
            result[i] *= nums[i];
        }

        return result;
    }
}