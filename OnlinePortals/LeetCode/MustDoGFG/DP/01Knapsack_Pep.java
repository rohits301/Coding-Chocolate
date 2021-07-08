import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        
        int n = scn.nextInt();
        int[] wts = new int[n];
        int[] val = new int[n];
        
        for(int i = 0; i < n; i++){
            val[i] = scn.nextInt();
        }
        for(int i = 0; i < n; i++){
            wts[i] = scn.nextInt();
        }
        
        int cap = scn.nextInt();
        
        int maxValue = Knapsack(wts, val, cap);
        System.out.println(maxValue);
    }
    private static int Knapsack(int[] wts, int[] val, int cap){
        int n = wts.length;
        int[][] dp = new int[n + 1][cap + 1];
        
        /*
        i for wts, val => i - 1, as mapping like 0th to (i=1)
        */
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[0].length; j++){
                if(j - wts[i - 1] >= 0){ // can play
                    dp[i][j] = Math.max(dp[i - 1][j], val[i - 1] + dp[i - 1][j - wts[i - 1]]);    
                } else { // cannot play, not enough balls
                    dp[i][j] = dp[i - 1][j];
                }
                
            }
        }
        return dp[n][cap];
    }
}