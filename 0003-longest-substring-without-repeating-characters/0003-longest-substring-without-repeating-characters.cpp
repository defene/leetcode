class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_set<char> set;

        int i = 0;
        int result = 0;
        for (int j = 0; j < s.length(); j++) {
            while (set.find(s[j]) != set.end()) {
                set.erase(s[i]);
                i++;
            }
            set.insert(s[j]);
            result = max(result, j - i + 1);
        }

        return result;
    }
};