class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        dfs(result, new StringBuilder(), n, n);
        return result;
    }

    private void dfs(List<String> result, StringBuilder sb, int left, int right) {
        if (left == 0 && right == 0) {
            result.add(sb.toString());
            return;
        }

        if (left > 0) {
            sb.append('(');
            dfs(result, sb, left - 1, right);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (right > 0 && left < right) {
            sb.append(')');
            dfs(result, sb, left, right - 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}