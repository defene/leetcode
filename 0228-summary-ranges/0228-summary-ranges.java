class Solution {
    public List<String> summaryRanges(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        
        List<String> result = new ArrayList<>();
        
        int start = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] != 1) {
                result.add(print(start, nums[i - 1]));
                start = nums[i];
            }
        }

        result.add(print(start, nums[nums.length - 1]));
        return result;
    }

    public String print(int start, int end) {
        if (start == end) {
            return new String(Integer.toString(start));
        }
        
        String s = new String(
                        Integer.toString(start) + 
                        "->" + 
                        Integer.toString(end));
        return s;
    }
}