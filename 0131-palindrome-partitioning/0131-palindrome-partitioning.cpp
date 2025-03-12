class Solution {
private:
    vector<vector<string>> partitions;
    vector<string> palindromes;

public:
    vector<vector<string>> partition(string &s) {
        if (s.empty()) {
            return partitions;
        }
        
        backtrack(s, 0);
        return partitions;
    }

private:
    void backtrack(const string &s, int start) {
        if (start >= s.length()) {
            partitions.push_back(palindromes);
        }

        for (int end = start; end < s.length(); end++) {
            if (is_palindrome(s, start, end)) {
                palindromes.push_back(s.substr(start, end - start + 1));
                backtrack(s, end + 1);
                palindromes.pop_back();
            }
        }
    }

    bool is_palindrome(const string &s, int low, int high) {
        while (low < high) {
            if (s[low++] != s[high--]) {
                return false;
            }
        }

        return true;
    }
};