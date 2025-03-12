class Solution {
private:
    vector<vector<int>> combinations;
    vector<int> cur;

public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        backtrack(candidates, target, 0);
        return combinations;
    }

private:
    void backtrack(vector<int>& candidates, int target, int index) {
        if (target <= 0) {
            if (target == 0) {
                combinations.push_back(cur);
            }
            return;
        }

        for (int i = index; i < candidates.size(); i++) {
            cur.push_back(candidates[i]);
            backtrack(candidates, target - candidates[i], i);
            cur.pop_back();
        }
    }
};