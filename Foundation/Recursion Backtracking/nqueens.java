import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[][] board = new int[n][n];
        
        printNQueens(board, "", 0);
    }

    public static void printNQueens(int[][] chess, String qsf, int row) {
        if(row==chess.length){
            System.out.println(qsf+".");
            return;
        }
        
        for(int col=0; col<chess.length; col++){
            if(isSafe(chess, row, col)){
                chess[row][col]=1;
                printNQueens(chess, qsf+row+"-"+col+", ", row+1);
                chess[row][col]=0;
            }
        }
        
    }
    
    public static boolean isSafe(int[][] chess, int r, int c){
        //same col
        for(int row=r-1; row>=0; row--){
            if(chess[row][c]==1){
                return false;
            }
        }
        
        //left diag
        for(int row=r-1,col=c-1; row>=0 && col>=0; row--,col--){
            if(chess[row][col]==1){
                return false;
            }
        }
        
        //right diag
        for(int row=r-1,col=c+1; row>=0 && col<chess.length; row--,col++){
            if(chess[row][col]==1){
                return false;
            }
        }
        
        return true;
    }
}