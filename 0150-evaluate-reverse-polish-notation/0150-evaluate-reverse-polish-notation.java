class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String token : tokens) {
            if (!token.equals("+") && !token.equals("-") && !token.equals("*") && !token.equals("/")) {
                stack.offerFirst(Integer.parseInt(token));
            } else {
                int second = stack.pollFirst();
                int first = stack.pollFirst();

                if (token.equals("+")) {
                    stack.offerFirst(first + second);
                } else if (token.equals("-")) {
                    stack.offerFirst(first - second);
                } else if (token.equals("*")) {
                    stack.offerFirst(first * second);
                } else {
                    stack.offerFirst(first / second);
                }
            }
        }

        return stack.pollFirst();
    }
}