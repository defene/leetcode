class Solution {
    public String longestCommonPrefix(String[] strs) {
        int i = 0;
        StringBuilder sb = new StringBuilder();
        if (strs[0].length() == 0) return sb.toString();
        
        while (true) {
            if (i >= strs[0].length()) {
                return sb.toString();
            }
            
            char currentChar = strs[0].charAt(i);
            
            char cur = strs[0].charAt(i); 
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || cur != strs[j].charAt(i)) {
                    return sb.toString();
                }
            }
            sb.append(cur);
            i++;
        } 
    }
}