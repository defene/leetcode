class Solution {
public:
    bool isAnagram(string s, string t) {
        if (s.size() != t.size()) return false;
        
        unordered_map<char, int> hashMap;

        for (char c : s) {
            hashMap[c]++;
        }

        for (char c : t) {
            if (hashMap.find(c) == hashMap.end()) {
                return false;
            } 
            hashMap[c]--;
            if (hashMap[c] == 0) {
                hashMap.erase(c);
            }
        }

        return hashMap.empty();
    }
};