class Solution {
public:
    int maxDistance(vector<vector<int>>& arrays) {
        int result = 0;
        int globalMin = arrays[0][0];
        int globalMax = arrays[0][arrays[0].size() - 1];

        for (int i = 1; i < arrays.size(); i++) {
            int curN = arrays[i].size();
            result = max(result, max(abs(arrays[i][curN - 1] - globalMin), abs(globalMax - arrays[i][0])));
            globalMin = min(globalMin, arrays[i][0]);
            globalMax = max(globalMax, arrays[i][curN - 1]);
        }

        return result;
    }
};