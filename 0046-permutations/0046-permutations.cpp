class Solution {
private:
    vector<vector<int>> permutations;

public:
    vector<vector<int>> permute(vector<int>& nums) {
        backtrack(nums, 0);
        return permutations;
    }

private:
    void backtrack(vector<int>& nums, int index) {
        if (index == nums.size()) {
            permutations.push_back(nums);
            return;
        }

        for (int i = index; i < nums.size(); i++) {
            swap(i, index, nums);
            backtrack(nums, index + 1);
            swap(i, index, nums);
        }
    }

    void swap(int i, int j, vector<int>& nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
};