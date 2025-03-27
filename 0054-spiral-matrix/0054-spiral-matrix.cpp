class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>>& matrix) {
        vector<int> result;
        
        int m = matrix.size();
        int n = matrix[0].size();

        int up = 0;
        int left = 0;
        int right = n - 1;
        int bottom = m - 1;
        while (left <= right && up <= bottom) {
            if (left == right) {
                for (int i = up; i <= bottom; i++) {
                    result.push_back(matrix[i][left]);
                }
                break;
            }

            if (up == bottom) {
                for (int i = left; i <= right; i++) {
                    result.push_back(matrix[up][i]);
                }
                break;
            }

            for (int i = left; i < right; i++) {
                result.push_back(matrix[up][i]);
            }

            for (int i = up; i < bottom; i++) {
                result.push_back(matrix[i][right]);
            }

            for (int i = right; i > left; i--) {
                result.push_back(matrix[bottom][i]);
            }

            for (int i = bottom; i > up; i--) {
                result.push_back(matrix[i][left]);
            }

            left++;
            right--;
            up++;
            bottom--;
        }

        return result;
    }
};