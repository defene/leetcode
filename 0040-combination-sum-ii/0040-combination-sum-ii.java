class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);

        dfs(result, candidates, target, 0, new ArrayList<Integer>());
        return result;
    }

    private void dfs(List<List<Integer>> result, int[] candidates, int target, int depth, List<Integer> cur) {
        if (depth == candidates.length || target == 0) {
            if (target == 0) {
                result.add(new ArrayList<>(cur));
            }
            return;
        }

        if (target >= candidates[depth]) {
            cur.add(candidates[depth]);
            dfs(result, candidates, target - candidates[depth], depth + 1, cur);
            cur.remove(cur.size() - 1);
        }

        int jump = depth;
        while (jump < candidates.length - 1 && candidates[jump] == candidates[jump + 1]) {
            jump++;
        }
        dfs(result, candidates, target, jump + 1, cur);
    }
}