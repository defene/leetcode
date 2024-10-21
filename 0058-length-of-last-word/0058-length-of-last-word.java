class Solution {
    public int lengthOfLastWord(String s) {
        char[] array = s.toCharArray();
        int i = s.length() - 1;
        int result = 0;
        while (i >= 0) {
            while (i >= 0 && array[i] == ' ') {
                i--;
            }
            while (i >= 0 && array[i] != ' ') {
                i--;
                result++;
            }
            break;
        }
        return result;
    }
}