class Solution {
private:
    vector<vector<int>> results;
    vector<int> cur_subset;

public:
    vector<vector<int>> subsets(vector<int>& nums) {
        if (nums.empty()) {
            return results;
        }

        backtrack(nums, 0);
        return results;
    }

private:
    void backtrack(vector<int>& nums, int index) {
        if (index == nums.size()) {
            results.push_back(cur_subset);
            return;
        }

        backtrack(nums, index + 1);
        cur_subset.push_back(nums[index]);
        backtrack(nums, index + 1);
        cur_subset.pop_back();
    }
};