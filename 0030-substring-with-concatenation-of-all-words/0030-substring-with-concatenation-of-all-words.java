class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) return result;

        int wordLen = words[0].length();
        int totalWords = words.length;
        int substringLen = wordLen * totalWords;
        
        Map<String, Integer> wordFreq = new HashMap<>();
        for (String word : words) {
            wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
        }
        
        for (int i = 0; i < wordLen; i++) {
            int left = i, count = 0;
            Map<String, Integer> window = new HashMap<>();
            for (int j = i; j <= s.length() - wordLen; j += wordLen) {
                String curWord = s.substring(j, j + wordLen);
                if (wordFreq.containsKey(curWord)) {
                    window.put(curWord, window.getOrDefault(curWord, 0) + 1);
                    count++;
                    
                    while (window.get(curWord) > wordFreq.get(curWord)) {
                        String leftWord = s.substring(left, left + wordLen);
                        window.put(leftWord, window.get(leftWord) - 1);
                        count--;
                        left += wordLen;
                    }
                    
                    if (count == totalWords) {
                        result.add(left);
                        String leftWord = s.substring(left, left + wordLen);
                        window.put(leftWord, window.get(leftWord) - 1);
                        count--;
                        left += wordLen;
                    }
                } else {
                    window.clear();
                    count = 0;
                    left = j + wordLen;
                }
            }
        }
        
        return result;
    }
}