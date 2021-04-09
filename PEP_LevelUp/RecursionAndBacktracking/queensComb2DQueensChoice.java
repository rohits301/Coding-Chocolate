import java.io.*;
import java.util.*;

public class Main {

    public static void queensCombinations(int qpsf, int tq, boolean[][] chess, int i, int j){
        // write your code here
        
        if(qpsf == tq){
            for(boolean[] ar : chess){
                for(boolean val : ar){
                    if(val == true){
                        System.out.print("q\t");
                    } else {
                        System.out.print("-\t");
                    }
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        
        int n = chess.length;
        
        for(int col = j + 1; col < n; col++){
            chess[i][col] = true;
            queensCombinations(qpsf + 1, tq, chess, i, col);
            chess[i][col] = false;
        }
        
        for(int row = i + 1; row < n; row++){
            for(int col = 0; col < n; col++){
                chess[row][col] = true;
                queensCombinations(qpsf + 1, tq, chess, row, col);
                chess[row][col] = false;
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];
        
        queensCombinations(0, n, chess, 0, -1);
    }
}
