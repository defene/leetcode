class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        
        int m = matrix.length;
        int n = matrix[0].length;

        int up = 0;
        int bottom = m - 1;
        int left = 0;
        int right = n - 1;
        while (left <= right && up <= bottom) {
            if (left == right) {
                for (int i = up; i <= bottom; i++) {
                    result.add(matrix[i][right]);
                } 
                break;
            }
            if (up == bottom) {
                for (int i = left; i <= right; i++) {
                    result.add(matrix[up][i]);
                }
                break;
            }
            
            for (int i = left; i < right; i++) {
                result.add(matrix[up][i]);
            }
            for (int i = up; i < bottom; i++) {
                result.add(matrix[i][right]);
            }
            for (int i = right; i > left; i--) {
                result.add(matrix[bottom][i]);
            }
            for (int i = bottom; i > up; i--) {
                result.add(matrix[i][left]);
            }

            up++;
            left++;
            right--;
            bottom--;
        }

        return result;
    }
}