import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        
        for(int i = 0; i < arr.length; i++){
            arr[i] = scn.nextInt();
        }
        
        int amt = scn.nextInt();
        
        int ans = ccCombinations(arr, amt);
        System.out.println(ans);
    }
    
    private static int ccCombinations(int[] arr, int amt){
        int[] dp = new int[amt + 1];
        
        dp[0] = 1; 
        
        for(int i = 0; i < arr.length; i++){
            for(int j = arr[i]; j < dp.length; j++){
                dp[j] += dp[j - arr[i]];
            }
        }
        return dp[amt];
    }
}