class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        dfs(nums, 0, result);
        return result;
    }

    private void dfs(int[] nums, int depth, List<List<Integer>> result) {
        if (depth == nums.length) {
            List<Integer> perm = new ArrayList<>();
            for (int num : nums) {
                perm.add(num);
            }
            result.add(perm);
            return;
        }

        for (int i = depth; i < nums.length; i++) {
            swap(nums, depth, i);
            dfs(nums, depth + 1, result);
            swap(nums, depth, i);
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}