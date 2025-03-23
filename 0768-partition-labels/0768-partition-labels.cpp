class Solution {
public:
    vector<int> partitionLabels(string s) {
        vector<int> lastOccurence(26, -1);
        vector<int> firstOccurence(26, -1);

        for (int i = 0; i < s.length(); i++) {
            int cur = s[i] - 'a';
            if (firstOccurence[cur] == -1) {
                firstOccurence[cur] = i;
            }
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            int cur = s[i] - 'a';
            if (lastOccurence[cur] == -1) {
                lastOccurence[cur] = i;
            }            
        }

        int intervalStart = 0;
        int intervalEnd = 0;
        vector<int> result;
        for (int i = 0; i < s.length(); i++) {
            int cur = s[i] - 'a';
            if (intervalEnd < firstOccurence[cur]) {
                result.push_back(intervalEnd - intervalStart + 1);
                intervalStart = i;
                intervalEnd = i;
            }

            intervalEnd = max(lastOccurence[cur], intervalEnd);
        }

        if (intervalEnd - intervalStart + 1 > 0) {
            result.push_back(intervalEnd - intervalStart + 1);
        }
        return result;
    }
};