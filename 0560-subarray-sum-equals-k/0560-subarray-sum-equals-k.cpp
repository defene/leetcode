class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        unordered_map<int, int> map;
        map[0] = 1;
        
        int curSum = 0;
        int result = 0;
        for (int i = 0; i < nums.size(); i++) {
            curSum += nums[i];
            if (map.find(curSum - k) != map.end()) {
                result += map[curSum - k];
            }
            map[curSum]++;
        }

        return result;
    }
};