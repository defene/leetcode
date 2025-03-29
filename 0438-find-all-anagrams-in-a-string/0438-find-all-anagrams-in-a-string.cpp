class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        if (p.length() > s.length()) {
            return {};
        }
        
        unordered_map<char, int> map;
        for (char c : p) {
            map[c]++;
        }

        vector<int> result;
        int windowLeft = 0;
        int matched = 0;
        for (int i = 0; i < p.length(); i++) {
            char cur = s[i];
            if (map.find(cur) != map.end()) {
                map[cur]--;
                if (map[cur] >= 0) {
                    matched++;
                }
            }
        }
        if (matched == p.length()) {
            result.push_back(windowLeft);
        }

        for (int windowRight = p.length(); windowRight < s.length(); windowRight++) {
            char right = s[windowRight];
            if (map.find(right) != map.end()) {
                map[right]--;
                if (map[right] >= 0) {
                    matched++;
                }
            }

            char left = s[windowLeft++];
            if (map.find(left) != map.end()) {
                map[left]++;
                if (map[left] > 0) {
                    matched--;
                }
            }

            if (matched == p.length()) {
                result.push_back(windowLeft);
            }
        }

        return result;
    }
};