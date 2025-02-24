class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < magazine.length(); i++) {
            char cur = magazine.charAt(i);
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char cur = ransomNote.charAt(i);
            if (!map.containsKey(cur) || map.get(cur) == 0) {
                return false;
            }

            map.put(cur, map.get(cur) - 1);
        }

        return true;
    }
}