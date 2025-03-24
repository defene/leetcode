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
        sort(str.begin(), str.end());
        return str;
    }
};