class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        
        if (s.length() < 4 || s.length() > 12) {
            return result;
        }

        dfs(result, new StringBuilder(), s.toCharArray(), 0, 0);
        return result;
    }

    private void dfs(List<String> result, StringBuilder sb, char[] ip, int depth, int index) {
        if (depth == 4 && index == ip.length) {
            sb.deleteCharAt(sb.length() - 1);
            result.add(sb.toString());
            sb.append('.');
            return;
        }

        if (depth == 4 || index == ip.length) {
            return;
        }

        for (int i = 1; i <= 3 && index + i <= ip.length; i++) {
            String substring = new String(ip, index, i);
            if (isValid(substring)) {
                sb.append(substring);
                sb.append('.');
                dfs(result, sb, ip, depth + 1, index + i);
                sb.setLength(sb.length() - substring.length() - 1);
            }
        }
    }

    private boolean isValid(String s) {
        if (s.charAt(0) == '0' && s.length() > 1) {
            return false;
        }

        int num = Integer.parseInt(s);
        return num >= 0 && num <= 255;
    }
}