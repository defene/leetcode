class Solution {
public:
    int trap(vector<int>& height) {
        int left = 0;
        int right = height.size() - 1;
        int result = 0;

        int leftMax = 0;
        int rightMax = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                leftMax = max(height[left], leftMax);
                result += leftMax - height[left];
                left++;
            } else {
                rightMax = max(height[right], rightMax);
                result += rightMax - height[right];
                right--;                
            }
        }

        return result;
    }
};