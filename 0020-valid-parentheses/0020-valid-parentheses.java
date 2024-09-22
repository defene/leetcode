class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) return false;
                char last = stack.pop();
                if (c == ')' && last != '(') return false;
                else if (c == ']' && last != '[') return false;
                else if (c == '}' && last != '{') return false;
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty();
    }
}