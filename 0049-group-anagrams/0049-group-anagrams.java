class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (int i = 0; i < strs.length; i++) {
            String cur = orderedString(strs[i]);
            if (map.containsKey(cur)) {
                List<String> curList = map.get(cur);
                curList.add(strs[i]);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(strs[i]);
                map.put(cur, newList);
            }
        }

        List<List<String>> result = new ArrayList<>();
        for (String key : map.keySet()) {
            result.add(map.get(key));
        }

        return result;
    }

    public String orderedString(String s) {
        char[] sArr = s.toCharArray();
        Arrays.sort(sArr);
        return new String(sArr);
    }
}