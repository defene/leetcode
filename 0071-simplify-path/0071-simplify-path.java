class Solution {
    public String simplifyPath(String path) {
        String[] words = path.split("/");
        Deque<String> stack = new ArrayDeque<>();

        for (String word : words) {
            if (word.equals(".") || word.equals("")) {
                continue;
            } else if (word.equals("..")) {
                stack.pollFirst();
            } else {
                stack.offerFirst(word);
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append("/");
            sb.append(stack.pollLast());
        }
        if (sb.isEmpty()) {
            sb.append("/");
        }

        return sb.toString();
    }
}