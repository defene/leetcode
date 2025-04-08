class Solution {
public:
    int findMaxConsecutiveOnes(vector<int>& nums) {
        int result = 0;
        int windowLeft = 0;
        int windowRight = 0;
        
        int zeroCount = 0;
        while (windowRight < nums.size()) {
            if (nums[windowRight] == 0) {
                zeroCount++;
            }

            while (zeroCount > 1) {
                if (nums[windowLeft] == 0) {
                    zeroCount--;
                }
                windowLeft++;
            }

            result = max(result, windowRight - windowLeft + 1);
            windowRight++;
        }

        return result;
    }
};