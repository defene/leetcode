class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        if (nums.empty()) {
            return {-1, -1};
        }
        
        int left = 0;
        int right = nums.size() - 1;

        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        if (nums[left] != target && nums[right] != target) {
            return {-1, -1};
        }
        int leftBound = (nums[left] == target ? left : right);

        left = 0;
        right = nums.size() - 1;

        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        int rightbound = (nums[right] == target ? right : left);

        return {leftBound, rightbound};
    }
};