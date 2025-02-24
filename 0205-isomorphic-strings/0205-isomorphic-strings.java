class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if (!map1.containsKey(sChar) && !map2.containsKey(tChar)) {
                map1.put(sChar, tChar);
                map2.put(tChar, sChar);
                continue;
            }

            if (map1.containsKey(sChar) && map2.containsKey(tChar)) {
                char prevTChar = map1.get(sChar);
                char prevSChar = map2.get(tChar);
                if (prevTChar != tChar || prevSChar != sChar) {
                    return false;
                }
            } else {
                return false;
            }
        }

        return true;
    }
}