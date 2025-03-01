class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {            
            if (i >= k + 1) {
                set.remove(nums[i - k - 1]);
            }

            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);            
        }

        return false;
    }
}