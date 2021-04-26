import java.io.*;
import java.util.*;

public class Main {

    public static boolean IsQueenSafe(int[][] chess, int row, int col) {
        // write your code here
        
        // 8 directions
        int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
        int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
        
        for(int radius = 1; radius < Math.max(chess.length, chess[0].length); radius++){
            for(int d = 0; d < dx.length; d++){
                
                int x = row + radius * dx[d];
                int y = col + radius * dy[d];
                
                if(x >= 0 && y >= 0 && (x < chess.length) && (y < chess[0].length) && (chess[x][y] > 0)){
                    return false;
                }
            }
        }
        return true;
    }

    public static void nqueens(int qpsf, int tq, int[][] chess) {
        // write your code here
        
        if(qpsf == tq){
            for(int[] ar : chess){
                for(int val : ar){
                    if(val == 0){
                        System.out.print("-\t");    
                    } else {
                        System.out.print("q" + val + "\t");
                    }
                    
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        
        for(int i = 0; i < chess.length * chess[0].length; i++){
            int row = i / chess[0].length;
            int col = i % chess[0].length;
            
            if(chess[row][col] == 0 && IsQueenSafe(chess, row, col)){
                chess[row][col] = (qpsf + 1);
                nqueens(qpsf + 1, tq, chess);
                chess[row][col] = 0;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] chess = new int[n][n];

        nqueens(0, n, chess);
    }
}