class Solution {
private:
    vector<vector<int>> DIRS = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    int m, n;

public:
    int orangesRotting(vector<vector<int>>& grid) {
        m = grid.size();
        n = grid[0].size();

        queue<int> q;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.push(i * n + j);
                }
            }
        }

        int minute = 0;
        while (!q.empty()) {
            bool rottedAny = false;
            int levelSize = q.size();
            
            for (int i = 0; i < levelSize; i++) {
                int cur = q.front();
                q.pop();

                int curX = cur / n;
                int curY = cur % n;

                for (int i = 0; i < 4; i++) {
                    int nextX = curX + DIRS[i][0];
                    int nextY = curY + DIRS[i][1];

                    if (check(nextX, nextY) && grid[nextX][nextY] == 1) {
                        grid[nextX][nextY] = 2;
                        q.push(nextX * n + nextY);
                        rottedAny = true;
                    }
                }
            }

            if (rottedAny) {
                minute++;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return minute;
    }

private:
    bool check(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
};