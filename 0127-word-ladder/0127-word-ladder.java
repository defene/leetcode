class Solution {
    class Pair<K, V> {
        K key;
        V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key; 
        }

        public V getValue() {
            return value;
        }
    }
    
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;
        
        Queue<Pair<String, Integer>> beginQueue = new LinkedList<>();
        Queue<Pair<String, Integer>> endQueue = new LinkedList<>();
        beginQueue.offer(new Pair<>(beginWord, 1));
        endQueue.offer(new Pair<>(endWord, 1));
        
        Map<String, Integer> beginVisited = new HashMap<>();
        Map<String, Integer> endVisited = new HashMap<>();
        beginVisited.put(beginWord, 1);
        endVisited.put(endWord, 1);
        
        while (!beginQueue.isEmpty() && !endQueue.isEmpty()) {
            int result = -1;
            if (beginQueue.size() <= endQueue.size()) {
                result = visitWord(beginQueue, beginVisited, endVisited, wordSet);
            } else {
                result = visitWord(endQueue, endVisited, beginVisited, wordSet);
            }
            if (result > -1) return result;
        }
        
        return 0;
    }
    
    private int visitWord(Queue<Pair<String, Integer>> queue, Map<String, Integer> visited,
                          Map<String, Integer> otherVisited, Set<String> wordSet) {
        int size = queue.size();
        for (int j = 0; j < size; j++) {
            Pair<String, Integer> current = queue.poll();
            String word = current.getKey();
            int level = current.getValue();
            
            for (int i = 0; i < word.length(); i++) {
                char[] charArray = word.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    charArray[i] = c;
                    String nextWord = new String(charArray);
                    
                    if (otherVisited.containsKey(nextWord)) {
                        return level + otherVisited.get(nextWord);
                    }
                    
                    if (wordSet.contains(nextWord) && !visited.containsKey(nextWord)) {
                        visited.put(nextWord, level + 1);
                        queue.offer(new Pair<>(nextWord, level + 1));
                    }
                }
            }
        }

        
        return -1;
    }
}