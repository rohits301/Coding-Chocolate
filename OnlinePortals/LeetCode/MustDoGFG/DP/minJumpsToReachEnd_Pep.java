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
        
        // int minMoves = climbStairsMM(arr);
        // System.out.println(minMoves);

        int[] qb = new int[n + 1];
        int ans = climbStairsMinJumps_Memo(arr, 0, qb);
        System.out.println(ans);
        // print(qb);
    }
    
    public static void print(int[] arr){
        for(int val : arr){
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static int climbStairsMinJumps_Memo(int[] arr, int i, int[] qb){
        
        if(i == arr.length){
            return 0;
        }
        
        if(qb[i] != 0){
            return qb[i];
        }
        
        int min = Integer.MAX_VALUE;
        
        for(int j = 1; j <= arr[i] && i + j <= arr.length; j++){
            int val = climbStairsMinJumps_Memo(arr, i + j, qb);
            min = Math.min(min, val); 
        }
        
        if(min != Integer.MAX_VALUE){
            min += 1;    
            qb[i] = min;   
        }
        return min;
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