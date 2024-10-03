class Solution {
    public int candy(int[] ratings) {
        int prevSlope = 0;
        int up = 0;
        int down = 0;
        int result = 0;
        for (int i = 1; i < ratings.length; i++) {
            int newSlope = 0;
            if (ratings[i] > ratings[i - 1]) {
                newSlope = 1;
            } else if (ratings[i] < ratings[i - 1]) {
                newSlope = -1;
            }

            if (prevSlope > 0 && newSlope == 0 ||
                prevSlope < 0 && newSlope >= 0) {
                    result += count(up) + count(down) + Math.max(up, down);
                    up = 0;
                    down = 0;
            }

            if (newSlope > 0) {
                up++;
            } else if (newSlope < 0) {
                down++;
            } else {
                result++;
            }

            prevSlope = newSlope;
        }
        result += count(up) + count(down) + Math.max(up, down) + 1;
        return result;
    }

    private int count(int n) {
        return n * (n + 1) / 2;
    }
}