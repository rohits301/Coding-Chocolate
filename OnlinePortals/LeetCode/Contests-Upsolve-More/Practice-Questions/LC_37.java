class Solution {
    public void solveSudoku(char[][] board) {
        sudokuHelper(board, 0, 0);
    }

    boolean sudokuHelper(char[][] board, int i, int j) {

        // 1. level and options => level->boxes, options -> possible opt.
        // 2. boxes mein movement => j == arr[0].length -> next row
        // 3. isValid => submatrix check

        if (i == board.length) {
            return true; // sudoku solved
        }

        int ni = 0, nj = 0;

        if (j == board[0].length - 1) {
            ni = i + 1;
            nj = 0;
        } else {
            ni = i;
            nj = j + 1;
        }

        if (board[i][j] != '.') {
            // already put value
            // i didn't put this value
            return sudokuHelper(board, ni, nj); // return as it is
        } else {
            for (char po = '1'; po <= '9'; po++) {

                if (isValid(board, i, j, po)) {
                    board[i][j] = po;

                    if (sudokuHelper(board, ni, nj)) {
                        return true;
                    } else {
                        board[i][j] = '.';
                    }
                }
            }
            // no option worked
            return false;
        }
    }

    boolean isValid(char[][] board, int row, int col, char val) {

        for (int i = 0; i < 9; i++) {
            // row check
            if (board[i][col] == val) {
                return false;
            }

            // col check
            if (board[row][i] == val) {
                return false;
            }
        }
        // sub-matrix check
        int smi = row / 3 * 3;
        int smj = col / 3 * 3;

        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                if (board[smi + i][smj + j] == val) {
                    return false;
                }
            }
        }

        return true;
    }
}