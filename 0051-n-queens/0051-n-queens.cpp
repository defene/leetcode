class Solution {
private:
    int n;
    vector<vector<string>> solutions;
    vector<int> cur_board;

public:
    vector<vector<string>> solveNQueens(int n) {
        this->n = n;
        backtrack(0);
        return solutions;
    }

private:
    void backtrack(int row) {
        if (row == n) {
            solutions.push_back(print_solution());
            return;
        }

        for (int col = 0; col < n; col++) {
            if (check(row, col)) {
                cur_board.push_back(col);
                backtrack(row + 1);
                cur_board.pop_back();
            }
        }
    }

    bool check(int curRow, int curCol) {
        for (int row = 0; row < cur_board.size(); row++) {
            if (cur_board[row] == curCol || 
                abs(curRow - row) == abs(curCol - cur_board[row])) {
                return false;
            }
        }
        return true;
    }

    vector<string> print_solution() {
        vector<string> board;
        for (int queen : cur_board) {
            string row(n, '.');
            row[queen] = 'Q';
            board.push_back(row);
        }
        return board;
    }
};