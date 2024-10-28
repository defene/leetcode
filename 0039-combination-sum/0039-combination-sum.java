class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        dfs(result, candidates, target, 0, new ArrayList<Integer>());
        return result;
    }

    private void dfs(List<List<Integer>> result, int[] candidates, 
                    int target, int prev, List<Integer> cur) {
        if (target == 0) {
            result.add(new ArrayList<>(cur));
            return;
        }

        for (int i = prev; i < candidates.length; i++) {
            if (candidates[i] <= target) {
                cur.add(candidates[i]);
                dfs(result, candidates, target - candidates[i], i, cur);
                cur.remove(cur.size() - 1);
            }
        }
    }
}