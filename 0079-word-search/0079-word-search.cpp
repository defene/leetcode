class Solution {
private:
    int m;
    int n;
    const vector<vector<int>> DIRS = {{0,1}, {1,0}, {-1,0}, {0,-1}};

public:
    bool exist(vector<vector<char>>& board, string word) {
        m = board.size();
        if (m == 0) return false;
        n = board[0].size();
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word[0] == board[i][j] && dfs(board, word, 0, i, j)) {
                        return true;
                }
            }
        }

        return false;
    }

private:
    bool dfs(vector<vector<char>>& board, string word, int index, int x, int y) {
        if (index == word.size() - 1) {
            return true;
        }

        board[x][y] = '#';
        for (int i = 0; i < DIRS.size(); i++) {
            int nextX = x + DIRS[i][0];
            int nextY = y + DIRS[i][1];
            if (check(nextX, nextY) && word[index + 1] == board[nextX][nextY]) {
                if (dfs(board, word, index + 1, nextX, nextY)) {
                    return true;
                }
            }
        }
        board[x][y] = word[index];

        return false;
    }

    bool check (int x, int y) {
        return x >=0 && x < m && y >= 0 && y < n;
    }
};