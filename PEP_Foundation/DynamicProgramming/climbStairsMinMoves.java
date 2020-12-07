import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        
        for(int i = 0; i < n; i++){
            arr[i] = scn.nextInt();    
        }
        int[] qb = new int[n + 1];
        int ans = climbStairsMinJumps_Memo(arr, 0, qb);
        System.out.println(ans);
        print(qb);
        
        // int dpAns = climbStairsMinJumps_Tab(arr);
        // System.out.println(dpAns);
        
    }
    
    public static void print(int[] arr){
        for(int val : arr){
            System.out.print(val + " ");
        }
        System.out.println();
    }
    
    public static int climbStairsMinJumps_Memo(int[] arr, int i, int[] dp){
        
        if(i == arr.length - 1){
            
            return 1;
        }
        
        if(dp[i] != 0){
            return dp[i];
        }
        
        if(arr[i] == 0){
            return arr.length;
        }
        
        int minMoves = arr.length;
        
        int val = 0;
        for(int j = 1; j <= arr[i] && (i + j) < arr.length; j++){
            val += climbStairsMinJumps_Memo(arr, i + j, dp);
        }
        minMoves = 1 + Math.min(minMoves, val);
        
        dp[i] = minMoves;
        return minMoves;
    }
    
    // public static int climbStairsMinJumps_Tab(int[] arr){
    //     int n = arr.length;
    //     int[] dp = new int[n + 1];
        
    //     for(int i = n; i >= 0; i--){
    //         if(i == n){
    //             dp[i] = 1;
    //         } else {
    //             for(int jump = 1; jump <= arr[i]; jump++){
    //                 if(i + jump <= n){
    //                     dp[i] += dp[jump + i];    
    //                 }
    //             } 
    //         }
    //     }
        
    //     // print(dp);
    //     return dp[0];
    // }

}