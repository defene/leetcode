class Solution {
public:
    int findMin(vector<int>& nums) {
        int left = 0;
        int right = nums.size() - 1;

        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (nums[right] <= nums[mid]) {
                left = mid;
            } else {
                right = mid;
            }
        }

        return min(nums[left], nums[right]);
    }
};