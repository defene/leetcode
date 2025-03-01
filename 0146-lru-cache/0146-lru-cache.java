class LRUCache {
    int capacity;
    LinkedHashMap<Integer, Integer> dic;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        dic = new LinkedHashMap<>(capacity, 0.75f, true);
    }
    
    public int get(int key) {
        if (dic.containsKey(key)) {
            return dic.get(key);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        dic.put(key, value);
        
        if (dic.size() > capacity) {
            Iterator<Map.Entry<Integer, Integer>> it = dic.entrySet().iterator();
            if (it.hasNext()) {
                Map.Entry<Integer, Integer> entry = it.next();
                it.remove();
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */