/*
!Input:
n = 5
arr[] = { 3, 3, 0, 2, 1};
!Output: 
ans = 5
memo_arr = 5 3 0 2 1 1 
*/
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
        // int[] qb = new int[n + 1];
        // int ans = climbStairsVarJumps_Memo(arr, 0, qb);
        // System.out.println(ans);
        // print(qb);
        
        int dpAns = climbStairsVarJumps_Tab(arr);
        System.out.println(dpAns);
        
    }
    
    public static void print(int[] arr){
        for(int val : arr){
            System.out.print(val + " ");
        }
        System.out.println();
    }
    
    public static int climbStairsVarJumps_Memo(int[] arr, int i, int[] qb){
        
        if(i == arr.length){
            qb[i] = 1;
            return 1;
        }
        if(i > arr.length){
            return 0;
        }
        
        if(qb[i] != 0){
            return qb[i];
        }
        
        int totalPaths = 0;
        for(int jump = 1; jump <= arr[i]; jump++){
            int pathsFromHere = climbStairsVarJumps_Memo(arr, jump + i, qb);
            totalPaths += pathsFromHere;
        }
        
        qb[i] = totalPaths; 
        return totalPaths;
    }
    
    public static int climbStairsVarJumps_Tab(int[] arr){
        int n = arr.length;
        int[] dp = new int[n + 1];
        
        for(int i = n; i >= 0; i--){
            if(i == n){
                dp[i] = 1;
            } else {
                for(int jump = 1; jump <= arr[i]; jump++){
                    if(i + jump <= n){
                        dp[i] += dp[jump + i];    
                    }
                } 
            }
        }
        
        // print(dp);
        return dp[0];
    }

}