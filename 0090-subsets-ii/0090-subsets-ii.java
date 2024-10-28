class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        dfs(result, nums, new ArrayList<>(), 0);
        return result;
    }

    private void dfs(List<List<Integer>> result, int[] nums, List<Integer> cur, int depth) {
        if (depth == nums.length) {
            result.add(new ArrayList<>(cur));
            return;
        }

        int jump = depth;
        while (jump < nums.length - 1 && nums[jump] == nums[jump + 1]) {
            jump++;
        }
        dfs(result, nums, cur, jump + 1);

        cur.add(nums[depth]);
        dfs(result, nums, cur, depth + 1);
        cur.remove(cur.size() - 1);
    }
}