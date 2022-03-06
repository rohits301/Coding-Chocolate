class Solution {
    // Expln by PEPCoding 
    // T: O(9^(n*n)), S: O(n*n)
    public void solveSudoku(char[][] arr) {
        sudokuSolver(arr, 0, 0);
    }

    boolean sudokuSolver(char[][] arr, int i, int j) {

        // base case
        if (i == arr.length) {
            return true;
        }

        int ni = 0, nj = 0;

        if (j == arr[0].length - 1) {
            ni = i + 1;
            nj = 0;
        } else {
            ni = i;
            nj = j + 1;
        }

        if (arr[i][j] != '.') {
            // already put value
            return sudokuSolver(arr, ni, nj);
        } else {
            // try opt.
            for (char po = '1'; po <= '9'; po++) {
                if (isValid(arr, i, j, po)) {

                    arr[i][j] = po;

                    if (sudokuSolver(arr, ni, nj)) {
                        return true;
                    } else {
                        arr[i][j] = '.';
                    }
                }
            }
            return false;
        }
    }

    boolean isValid(char[][] arr, int row, int col, int val) {
        // row and col check
        for (int i = 0; i < 9; i++) {
            if (arr[row][i] == val)
                return false;

            if (arr[i][col] == val)
                return false;
        }

        // submatrix check
        int smi = row / 3 * 3;
        int smj = col / 3 * 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                if (arr[smi + i][smj + j] == val)
                    return false;
            }
        }
        return true;
    }
}