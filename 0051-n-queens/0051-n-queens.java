class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        dfs(result, new ArrayList<Integer>(), n, 0);
        return result;
    }

    private void dfs(List<List<String>> result, List<Integer> cur, int n, int row) {
        if (row == n) {
            List<String> curResult = print(cur);
            result.add(curResult);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (check(i, row, cur)) {
                cur.add(i);
                dfs(result, cur, n, row + 1);
                cur.remove(cur.size() - 1);
            }
        }
    }

    private boolean check(int col, int row, List<Integer> cur) {
        for (int i = 0; i < cur.size(); i++) {
            int j = cur.get(i);
            if (col == j) {
                return false;
            }
            if (Math.abs(col - j) == Math.abs(row - i)) {
                return false;
            }
        }

        return true;
    }

    private List<String> print(List<Integer> cur) {
        int n = cur.size();
        List<String> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int queen = cur.get(i);
            for (int j = 0; j < n; j++) {
                if (j != queen) {
                    sb.append('.');
                } else {
                    sb.append('Q');
                }
            }
            result.add(sb.toString());
        }

        return result;
    } 
}