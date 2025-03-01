class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int result = 0;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int cur = num;
                int count = 1;
                while (set.contains(cur + 1)) {
                    count++;
                    cur++;
                }
                result = Math.max(count, result);
            }
        }

        return result;
    }
}