class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] column_zeros = new int[n];
        int[] row_zeros = new int[m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    column_zeros[j] = 1;
                    row_zeros[i] = 1;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (column_zeros[j] == 1 || row_zeros[i] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}