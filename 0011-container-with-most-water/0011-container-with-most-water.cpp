class Solution {
public:
    int maxArea(vector<int>& height) {
        int left = 0;
        int right = height.size() - 1;
        int result = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                int len = height[left];
                int width = right - left;
                result = max(result, len * width);
                left++;
            } else {
                int len = height[right];
                int width = right - left;
                result = max(result, len * width);
                right--;                
            }
        }

        return result;
    }
};