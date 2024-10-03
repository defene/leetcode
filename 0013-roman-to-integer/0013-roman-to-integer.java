class Solution {
    public int romanToInt(String s) {
        char[] array = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int prev = 1;
        int result = 0;
        for (int i = array.length - 1; i >= 0; i--) {
            int cur = map.get(array[i]);
            if (cur >= prev) result += cur;
            else result -= cur;
            prev = cur;
        }

        return result;
    }
}