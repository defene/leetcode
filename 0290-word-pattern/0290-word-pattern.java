class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map1 = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();

        String[] words = s.split(" ");
        char[] patternArr = pattern.toCharArray();

        if (words.length != patternArr.length) {
            return false;
        }

        for (int i = 0; i < patternArr.length; i++) {
            if (map1.containsKey(patternArr[i])) {
                if (!words[i].equals(map1.get(patternArr[i]))) {
                    return false;
                }
            } else {
                map1.put(patternArr[i], words[i]);
            }
            if (map2.containsKey(words[i])) {
                if (patternArr[i] != map2.get(words[i])) {
                    return false;
                }
            } else {
                map2.put(words[i], patternArr[i]);
            }
        }

        return true;
    }
}