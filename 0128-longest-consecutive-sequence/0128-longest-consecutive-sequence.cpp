class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        unordered_set<int> set;
        for (int num : nums) {
            set.insert(num);
        }

        int result = 0;
        for (int num : set) {
            if (set.find(num - 1) == set.end()) {
                int curCount = 1;
                int curElement = num;

                while (set.find(curElement + 1) != set.end()) {
                    curCount++;
                    curElement++;
                }

                result = max(result, curCount);
            }
        }

        return result;
    }
};