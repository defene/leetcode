class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] arr = s.toCharArray();
        Set<Character> set = new HashSet<>();
         
        int globalMax = 0;
        int windowLeft = 0;
        for (int windowRight = 0; windowRight < arr.length; windowRight++) {
            while (set.contains(arr[windowRight])) {
                set.remove(arr[windowLeft++]);
            }
            
            set.add(arr[windowRight]);
            globalMax = globalMax > set.size() ? globalMax : set.size();    
        }

        return globalMax;
    }
}