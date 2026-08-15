class Solution {
    public boolean isValidSudoku(char[][] board) {
        int m = board.length, n = board[0].length;

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (board[row][col] == '.')
                    continue;

                if (!isValidNumber(board, row, col, m, n)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean isValidNumber(char[][] board, int i, int j, int m, int n) {
        int num = board[i][j];

        for (int k = 0; k < m; k++) {
            if (k == i)
                continue;
            if (board[k][j] == num)
                return false;
        }

        for (int k = 0; k < n; k++) {
            if (k == j)
                continue;
            if (board[i][k] == num)
                return false;
        }

        int boxRowStart = (i / 3) * 3;
        int boxColStart = (j / 3) * 3;

        for (int boxRow = boxRowStart; boxRow < boxRowStart + 3; boxRow++) {
            for (int boxCol = boxColStart; boxCol < boxColStart + 3; boxCol++) {
                if (boxRow == i && boxCol == j)
                    continue;
                if (board[boxRow][boxCol] == num)
                    return false;
            }
        }

        return true;
    }
}
