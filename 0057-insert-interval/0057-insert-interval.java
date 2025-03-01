class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0) {
            return new int[][]{{newInterval[0], newInterval[1]}};
        }
        
        int n = intervals.length;
        List<int[]> merged = new ArrayList<>();

        int i = 0;
        while (i < n && intervals[i][1] < newInterval[0]) {
            merged.add(intervals[i]);
            i++;
        }

        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        merged.add(newInterval);
        
        while (i < n) {
            merged.add(intervals[i]);
            i++;            
        }

        return merged.toArray(new int[merged.size()][]);
    }
}