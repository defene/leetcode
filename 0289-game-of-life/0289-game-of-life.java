class Solution {
    public static final int[][] D = {
        {0, 1}, {1, 1}, {1, 0}, {1, -1},
        {0, -1}, {-1, -1}, {-1, 0}, {-1, 1}
    };
    
    //1: normal alive, 2: next new, 0: normal dead, -1: next dead
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = check(board, i, j);
                if (board[i][j] == 1) {
                    if (count < 2 || count > 3) {
                        board[i][j] = -1;
                    }
                } else {
                    if (count == 3) {
                        board[i][j] = 2;
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = board[i][j] > 0 ? 1 : 0;
            }
        }

        return;        
    }

    private int check(int[][] board, int x, int y) {
        int m = board.length;
        int n = board[0].length;
        
        int count = 0;
        for (int i = 0; i < 8; i++) {
            int curX = x + D[i][0];
            int curY = y + D[i][1];
            if (isValid(curX, curY, m, n) &&
                (board[curX][curY] == 1 || board[curX][curY] == -1)) {
                count++;
            }
        }

        return count;
    }

    private boolean isValid(int i, int j, int m, int n) {
        return i >= 0 && i < m && j >= 0 && j < n;
    }
}