class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        
        char[][] ZigzagArr = new char[numRows][s.length()];
        char[] inputArr = s.toCharArray();

        int curRow = 0;
        int curCol = 0;
        boolean down = true;
        for (char c : inputArr) {
            ZigzagArr[curRow][curCol] = c;
            
            if (curRow == numRows - 1) {
                down = false;
            }
            if (curRow == 0) {
                down = true;
            }
            
            if (down) {
                curRow++;
            } else {
                curRow--;
                curCol++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < s.length(); j++) {
                if (ZigzagArr[i][j] != 0) {
                    sb.append(ZigzagArr[i][j]);
                }
            }
        }

        return sb.toString();
    }
}