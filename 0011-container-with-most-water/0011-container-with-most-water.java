class Solution {
    public int maxArea(int[] height) {
        int globalMax = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            if (height[left] < height[right]) {
                int area = (right - left) * height[left];
                globalMax = Math.max(globalMax, area);
                left++;
            } else {
                int area = (right - left) * height[right];
                globalMax = Math.max(globalMax, area);
                right--;
            }
        }

        return globalMax;
    }
}