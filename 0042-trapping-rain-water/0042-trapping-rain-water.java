class Solution {
    public int trap(int[] height) {
        int leftMax = 0;
        int rightMax = 0;

        int left = 0;
        int right = height.length - 1;
        int water = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                leftMax = Math.max(height[left], leftMax);
                water += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(height[right], rightMax);
                water += rightMax - height[right];
                right--;
            }
        }

        return water;
    }
}