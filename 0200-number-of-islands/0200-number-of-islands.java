class Solution {
    public static final int[][] DIRS = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    BFS(grid, i, j);
                }
            }
        }

        return count;
    }

    private void BFS(char[][] grid, int curI, int curJ) {
        int m = grid.length;
        int n = grid[0].length;    
    
        grid[curI][curJ] = '0';
        Queue<Integer> neighbors = new ArrayDeque<>();
        neighbors.offer(curI * n + curJ);

        while (!neighbors.isEmpty()) {
            int id = neighbors.poll();
            for (int i = 0; i < DIRS.length; i++) {
                int row = id / n + DIRS[i][0];
                int col = id % n + DIRS[i][1];

                if (check(row, m, col, n) && grid[row][col] == '1') {
                    neighbors.add(row * n + col);
                    grid[row][col] = '0';
                }
            }
        }
    }

    private boolean check(int row, int m, int col, int n) {
        return row >= 0 && row < m && col >= 0 && col < n;
    }
}