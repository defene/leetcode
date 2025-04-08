class Solution {
public:
    int lengthOfLongestSubstringTwoDistinct(string s) {
        int maxLen = 0;
        int windowLeft = 0;
        int windowRight = 0;
        unordered_map<char, int> map;
        while (windowRight < s.length()) {
            map[s[windowRight]]++;
            
            while (map.size() > 2) {
                map[s[windowLeft]]--;
                if (map[s[windowLeft]] == 0)
                    map.erase(s[windowLeft]);
                windowLeft++;
            }
            
            maxLen = max(maxLen, windowRight - windowLeft + 1);
            windowRight++;
        }

        return maxLen;
    } 
};