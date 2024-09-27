class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] counts = new int[n + 1];

        for (int c : citations) {
            counts[Math.min(c, n)]++;
        }

        int result = n;
        for (int count = counts[n]; result > count; count += counts[result]) {
            result--;
        }

        return result;
    }
}