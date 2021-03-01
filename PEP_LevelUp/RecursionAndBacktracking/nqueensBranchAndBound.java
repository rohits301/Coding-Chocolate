import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        boolean[][] board = new boolean[n][n];
        // write your code here

        boolean[] cols = new boolean[n];
        boolean[] normalDiag = new boolean[2 * n - 1];
        boolean[] reverseDiag = new boolean[2 * n - 1];

        nqueens(board, 0, cols, normalDiag, reverseDiag, "");
    }

    private static void nqueens(boolean[][] board, int r, boolean[] cols, boolean[] normalDiag, boolean[] reverseDiag,
            String asf) {

        int n = board.length; // board.length = board[0].length (SQUARE)

        if (r == n) {
            System.out.println(asf + ".");
            return;
        }

        for (int c = 0; c < n; c++) {
            if (cols[c] == false && normalDiag[r + c] == false && reverseDiag[r - c + n - 1] == false) {
                board[r][c] = true;
                cols[c] = true;
                normalDiag[r + c] = true;
                reverseDiag[r - c + n - 1] = true;

                nqueens(board, r + 1, cols, normalDiag, reverseDiag, asf + r + "-" + c + ", ");

                board[r][c] = false;
                cols[c] = false;
                normalDiag[r + c] = false;
                reverseDiag[r - c + n - 1] = false;
            }
        }

    }

}