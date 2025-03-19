class Solution {
public:
    int maxProduct(vector<int>& nums) {
        int result = INT_MIN;
        int prevMin = 1;
        int prevMax = 1;

        for (int i = 0; i < nums.size(); i++) {
            int cur = nums[i];
            int curMin = prevMin * nums[i];
            int curMax = prevMax * nums[i];

            prevMax = max(cur, max(curMin, curMax));
            prevMin = min(cur, min(curMin, curMax));
            result = max(prevMax, result);
        }

        return result;
    }
};