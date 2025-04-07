class Solution {
public:
    int shortestWay(string source, string target) {
        unordered_set<char> set;
        for (char c : source) {
            set.insert(c);
        }
        for (char c : target) {
            if (set.find(c) == set.end()) {
                return -1;
            }
        }
        
        int result = 0;
        int j = 0;
        while (j < target.length()) {
            int i = 0;
            result++;
            while (i < source.length() && j < target.length()) {
                if (target[j] == source[i]) {
                    j++;
                }
                i++;
            }
        }

        return result;
    }
};