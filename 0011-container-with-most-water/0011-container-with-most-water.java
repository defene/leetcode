class Solution {
    public int maxArea(int[] height) {
        int globalMax = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            globalMax = Math.max(globalMax, area);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return globalMax;
    }
}