class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        sort(intervals.begin(), intervals.end());

        vector<vector<int>> result;
        int curResultLeft = intervals[0][0];
        int curResultRight = intervals[0][1];
        for (int i = 1; i < intervals.size(); i++) {
            int curLeft = intervals[i][0];
            int curRight = intervals[i][1];

            if (curLeft <= curResultRight) {
                curResultRight = max(curResultRight, curRight);
            } else {
                result.push_back({curResultLeft, curResultRight});
                curResultLeft = curLeft;
                curResultRight = curRight;
            }
        }
        result.push_back({curResultLeft, curResultRight});

        return result;
    } 
};