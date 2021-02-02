import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        
        for(int i = 0; i < n; i++){
            arr[i] = scn.nextInt();
        }
        
        int minMoves = climbStairsMM(arr);
        System.out.println(minMoves);
    }
    
    private static int climbStairsMM(int[] arr){
        int n = arr.length;
        Integer[] dp = new Integer[n + 1];
        dp[n] = 0;
        
        for(int i = n - 1; i >= 0; i--){
            int min = Integer.MAX_VALUE;
            for(int jump = 1; jump <= arr[i] && i + jump <= n; jump++){
                // already handled since, it will not come into this loop
                // if(arr[i] == 0){
                //     continue;
                // } 
                
                if(dp[i + jump] != null){
                    min = Math.min(dp[i + jump], min);
                }
            }
            if(min != Integer.MAX_VALUE){
                dp[i] = min + 1;
            } else {
                dp[i] = null; // which is already null, hence this is redundant
            }
        }
        // for(int i = 0; i <= n; i++){
        //     System.out.print(dp[i] + " ");
        // }
        // System.out.println();
        
        return dp[0];
    }

}