class Solution {
    public String minWindow(String s, String t) {
        char[] tArr = t.toCharArray();
        Map<Character, Integer> map = new HashMap<>();

        for (char c : tArr) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int count = 0;
        int minLen = Integer.MAX_VALUE;
        int start = 0;
        int windowLeft = 0;
        char[] sArr = s.toCharArray();
        for (int windowRight = 0; windowRight < sArr.length; windowRight++) {
            char c = sArr[windowRight];
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) >= 0) {
                    count++;
                }
            }
            
            while (count == t.length()) {
                if (windowRight - windowLeft + 1 < minLen) {
                    minLen = windowRight - windowLeft + 1;
                    start = windowLeft;
                }

                char leftChar = sArr[windowLeft];
                if (map.containsKey(leftChar)) {
                    map.put(leftChar, map.get(leftChar) + 1);
                    if (map.get(leftChar) > 0) {
                        count--;
                    }
                }

                windowLeft++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : new String(sArr, start, minLen);
    }
}