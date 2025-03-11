class Solution {
private:
    vector<string> combinations;

public:
    vector<string> generateParenthesis(int n) {
        if (n <= 0) {
            return combinations;
        }
        
        backtrack(n, n, "");
        return combinations;
    }

private:
    void backtrack(int cur_left, int cur_right, string path) {
        if (cur_left == 0 && cur_right == 0) {
            combinations.push_back(path);
            return;
        }

        if (cur_left > 0) {
            path.push_back('(');
            backtrack(cur_left - 1, cur_right, path);
            path.pop_back();
        }

        if (cur_left < cur_right) {
            path.push_back(')');
            backtrack(cur_left, cur_right - 1, path);
            path.pop_back();            
        }
    }
};