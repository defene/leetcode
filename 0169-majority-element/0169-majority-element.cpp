class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int resultCount = 1;
        int result = nums[0];
        for (int i = 1; i < nums.size(); i++) {
            if (nums[i] != result) {
                resultCount--;
                if (resultCount < 0) {
                    result = nums[i];
                    resultCount = 1;
                }
            } else {
                resultCount++;
            }
        }

        return result;
    }
};