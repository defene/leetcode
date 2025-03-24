class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        unordered_map<string, vector<string>> anagramMap;
        for (auto& str : strs) {
            string sortedStr = getSortedCopy(str);
            anagramMap[sortedStr].push_back(str);
        }
        
        vector<vector<string>> result;
        for (auto& p : anagramMap) {
            result.push_back(p.second);
        }
        
        return result;
    }

private:
    string getSortedCopy(string str) {
        const int ALPHABET_SIZE = 26;
        std::vector<int> count(ALPHABET_SIZE, 0);
        
        for (char c : str) {
            count[c - 'a']++;
        }
        
        std::string sorted;
        sorted.reserve(str.size());
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            sorted.append(count[i], 'a' + i);
        }

        return sorted;
    }
};