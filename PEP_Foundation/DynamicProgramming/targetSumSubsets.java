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
        int tar = scn.nextInt();
        
        boolean ans = targetSumSubsets(arr, tar);
        System.out.println(ans);
    }
    private static boolean targetSumSubsets(int[] arr, int tar){
        
        boolean[][] dp = new boolean[arr.length + 1][tar + 1];
        
        for(int i = 0; i < dp.length; i++){
            for(int j = 0; j < dp[0].length; j++){
                
                if(i == 0 && j == 0){
                    dp[i][j] = true;
                } else if(i == 0){
                    dp[i][j] = false;
                } else if(j == 0){
                    dp[i][j] = true;
                } else {
                    // pichle waalon ne bna liye
                    if(dp[i - 1][j] == true){ 
                        dp[i][j] = true; // I don't need to bat
                    } else { 
                        // batting aayegi par kar paaunga ya nhi woh decide hoga
                        
                        int val = arr[i - 1]; // mapping => dp ka i = arr ka i-1
                        if(j - val >= 0){
                            dp[i][j] = dp[i - 1][j - val];
                        } else {
                            dp[i][j] = dp[i - 1][j];
                        }
                    }
                }
            }
        }
        
        return dp[arr.length][tar];
    }
}