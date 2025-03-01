class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> {
            if (a[1] < b[1]) return -1;
            else if (a[1] == b[1]) return 0;
            else return 1;
        });

        int arrows = 1;
        int curCover = points[0][1]; 
        for (int[] point : points) {
            if (point[0] > curCover) {
                arrows++;
                curCover = point[1];
            }
        }

        return arrows;
    }
}