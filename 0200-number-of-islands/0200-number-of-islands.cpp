class Solution {
public:
    vector<vector<int>> DIRS = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    int m, n;

public:
    int numIslands(vector<vector<char>>& grid) {
        m = grid.size();
        n = grid[0].size();

        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }

private:
    void dfs(vector<vector<char>>& grid, int x, int y) {
        grid[x][y] = '0';
        for (int i = 0; i < 4; i++) {
            int nextX = x + DIRS[i][0];
            int nextY = y + DIRS[i][1];

            if (check(nextX, nextY) && grid[nextX][nextY] == '1') {
                dfs(grid, nextX, nextY);
            }
        }
    }

    bool check(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
};