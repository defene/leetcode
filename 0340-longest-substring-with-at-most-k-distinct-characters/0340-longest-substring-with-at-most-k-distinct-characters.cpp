class Solution {
public:
    int lengthOfLongestSubstringKDistinct(string s, int k) {
        int result = 0;
        int windowLeft = 0;
        int windowRight = 0;
        
        unordered_map<char, int> map;
        while (windowRight < s.length()) {
            map[s[windowRight]]++;

            while (map.size() > k) {
                map[s[windowLeft]]--;

                if (map[s[windowLeft]] == 0) {
                    map.erase(s[windowLeft]);
                }
                
                windowLeft++;
            }

            result = max(result, windowRight - windowLeft + 1);
            windowRight++;
        }

        return result;
    }
};