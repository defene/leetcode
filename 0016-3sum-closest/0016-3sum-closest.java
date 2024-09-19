class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        int globalMin = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                globalMin = Math.abs(globalMin - target) > Math.abs(target - sum) ? sum : globalMin;
                if (sum < target) left++;
                else if (sum > target) right--;
                else return sum;
            }
        }

        return globalMin;
    }
}