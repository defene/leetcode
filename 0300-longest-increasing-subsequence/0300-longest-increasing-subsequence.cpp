class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        vector<int> dp;
        dp.push_back(nums[0]);

        for (int i = 1; i < nums.size(); i++) {
            if (nums[i] > dp[dp.size() - 1]) {
                dp.push_back(nums[i]);
            } else {
                int j = binarySearch(dp, nums[i]);
                dp[j] = nums[i];
            }
        }

        return dp.size();
    }

private:
    int binarySearch(vector<int>& nums, int target) {
        int left = 0;
        int right = nums.size() - 1;

        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        if (nums[left] < target) {
            return right;
        }
        return left;
    }
};