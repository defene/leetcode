class Solution {
    public boolean isValidSudoku(char[][] board) {
        int N = 9;
        
        Set<Character>[] rowSets = new Set[N];
        Set<Character>[] colSets = new Set[N];
        Set<Character>[] boxSets = new Set[N];

        for (int i = 0; i < N; i++) {
            rowSets[i] = new HashSet<>();
            colSets[i] = new HashSet<>();
            boxSets[i] = new HashSet<>();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Character cur = board[i][j];
                
                if (cur == '.') {
                    continue;
                }
                
                if (!rowSets[i].contains(cur)) {
                    rowSets[i].add(cur);
                } else {
                    return false;
                }

                if (!colSets[j].contains(cur)) {
                    colSets[j].add(cur);
                } else {
                    return false;
                }

                int boxNum = (i / 3) * 3 + j / 3;
                if (!boxSets[boxNum].contains(cur)) {
                    boxSets[boxNum].add(cur);
                } else {
                    return false;
                }                
            }
        }

        return true;
    }
}