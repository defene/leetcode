class Solution {
public:
    bool isOneEditDistance(string s, string t) {
        if (s.length() > t.length()) {
            return isOneEditDistance(t, s);
        }

        if (s.length() < t.length() - 1) {
            return false;
        }

        int diff = 0;
        for (int i = 0; i < t.length(); i++) {
            if (t[i] != s[i]) {
                if (t.length() != s.length()) {
                    return s.substr(i) == t.substr(i + 1);
                } else {
                    return s.substr(i + 1) == t.substr(i + 1);
                }
            }
        }

        return false;
    }
};