import java.io.*;
import java.util.*;

public class Main {

    //* Direction Array Approach for IsSafe
    /*
    public static boolean IsQueenSafe(boolean[][] chess, int row, int col) {
        int[] dArrX = { 0, -1, -1, -1 };
        int[] dArrY = { -1, -1, 0, 1 };

        for (int radius = 1; radius < Math.max(chess.length, chess[0].length); radius++) {
            for (int d = 0; d < 4; d++) {

                int x = row + radius * dArrX[d];
                int y = col + radius * dArrY[d];

                if (x >= 0 && y >= 0 && y < chess[0].length && x < chess.length && chess[x][y]) {
                    return false;
                }
            }
        }
        return true;
    }
    */
    public static boolean IsQueenSafe(boolean[][] chess, int row, int col) {

        for(int i = row, j = col; j >= 0; j--){
            if(chess[i][j]){
                return false;
            }
        }
        for(int i = row, j = col; i >= 0 && j >= 0; i--, j--){
            if(chess[i][j]){
                return false;
            }
        }
        for(int i = row, j = col; i >= 0; i--){
            if(chess[i][j]){
                return false;
            }
        }
        for(int i = row, j = col; i >= 0 && j < chess.length; i--, j++){
            if(chess[i][j]){
                return false;
            }
        }
        
        return true;
    }

    public static void nqueens(int qpsf, int tq, boolean[][] chess, int lcno) {
        if (qpsf == tq) {
            for (int row = 0; row < chess.length; row++) {
                for (int col = 0; col < chess.length; col++) {
                    System.out.print(chess[row][col] ? "q\t" : "-\t");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        for (int i = lcno + 1; i < chess.length * chess.length; i++) {
            int row = i / chess.length;
            int col = i % chess.length;

            if (chess[row][col] == false && IsQueenSafe(chess, row, col)) {
                chess[row][col] = true;
                nqueens(qpsf + 1, tq, chess, row * chess.length + col);
                chess[row][col] = false;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];

        nqueens(0, n, chess, -1);
    }
}