class Solution {
public:
    int numKLenSubstrNoRepeats(string s, int k) {
        unordered_set<char> set;

        int windowLeft = 0;
        int count = 0;
        for (int windowRight = 0; windowRight < s.length(); windowRight++) {
            if (set.find(s[windowRight]) != set.end()) {
                while (s[windowLeft] != s[windowRight]) {
                    set.erase(s[windowLeft]);
                    windowLeft++;
                }
                set.erase(s[windowLeft]);
                windowLeft++;
            }

            set.insert(s[windowRight]);
            if (windowRight - windowLeft + 1 == k) {
                count++;
                set.erase(s[windowLeft]);
                windowLeft++;                
            }
        }

        return count;
    }
};