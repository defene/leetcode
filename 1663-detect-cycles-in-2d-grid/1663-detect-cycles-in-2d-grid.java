class Solution {
    private static final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; 
    
    public boolean containsCycle(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    if (dfs(grid, visited, grid[i][j], i, j, -1, -1)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] grid, boolean[][] visited, char letter, 
                        int i, int j, int parentI, int parentJ) {
        if (visited[i][j]) {
            return true;
        }

        visited[i][j] = true;

        for (int[] dir : DIRS) {
            int nextI = i + dir[0];
            int nextJ = j + dir[1];

            if (isValid(nextI, nextJ, grid.length, grid[0].length) &&
                grid[nextI][nextJ] == letter &&
                !(nextI == parentI && nextJ == parentJ)) {
                if (dfs(grid, visited, letter, nextI, nextJ, i, j)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean isValid(int i, int j, int m, int n) {
        return i >= 0 && j >= 0 && i < m && j < n;
    }
}