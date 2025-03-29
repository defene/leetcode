class Solution {
public:
    string minWindow(string s, string t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        unordered_map<char, int> map;
        for (char c : t) {
            map[c]++;
        }
        
        int windowLeft = 0;
        int matched = 0;
        int start = 0;
        int result = INT_MAX;
        for (int windowRight = 0; windowRight < s.length(); windowRight++) {
            char cur = s[windowRight];
            if (map.find(cur) != map.end()) {
                map[cur]--;
                if (map[cur] >= 0) {
                    matched++;
                }
            }

            while (matched == t.length()) {
                if (windowRight - windowLeft + 1 < result) {
                    result = windowRight - windowLeft + 1;
                    start = windowLeft;
                }
                
                char left = s[windowLeft];
                if (map.find(left) != map.end()) {
                    map[left]++;
                    if (map[left] > 0) {
                        matched--;
                    }
                }

                windowLeft++;
            }
        }

        return result == INT_MAX ? "" : s.substr(start, result);
    }
};