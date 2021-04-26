import java.io.*;
import java.util.*;

public class Main {

    public static void queensCombinations(int qpsf, int tq, boolean[][] chess, int lqwph) {
        
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
        
        // lqwph = last queen was placed here
        int total = chess.length * chess[0].length;
        
        for(int i = lqwph + 1; i < total; i++){
            int row = i / chess[0].length;
            int col = i % chess.length;
            
            chess[row][col] = true;
            queensCombinations(qpsf + 1, tq, chess, i);
            chess[row][col] = false;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean[][] chess = new boolean[n][n];

        queensCombinations(0, n, chess, -1);
    }
}