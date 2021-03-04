
// import java.io.*;
import java.util.*;

public class Main {
    public static void display(int[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void solveSudoku(int[][] board, int i, int j) {
        // write your code here

        // i = 9
        if (i == board.length) {
            display(board);
            return;
        }

        int ni = 0; // new i
        int nj = 0; // new j

        if (j == board[0].length - 1) { // at last column, change row and start from 0
            ni = i + 1;
            nj = 0;
        } else {
            ni = i;
            nj = j + 1;
        }

        if (board[i][j] == 0) {
            for (int option = 1; option <= 9; option++) {
                if (isPositionValid(board, i, j, option)) {
                    board[i][j] = option;
                    solveSudoku(board, ni, nj);
                    board[i][j] = 0; // remove the option
                }
            }
        } else {
            solveSudoku(board, ni, nj);
        }
    }

    public static boolean isPositionValid(int[][] board, int row, int col, int option) {
        // row check
        for (int j = 0; j < board[0].length; j++) {
            if (board[row][j] == option) {
                return false;
            }
        }

        // col check
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == option) {
                return false;
            }
        }

        // sub matrix check
        int smi = row / 3 * 3; // subMatrix i
        int smj = col / 3 * 3; // subMatrix j
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[smi + i][smj + j] == option) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int[][] arr = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                arr[i][j] = scn.nextInt();
            }
        }

        solveSudoku(arr, 0, 0);
    }
}
