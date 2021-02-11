import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        
        int noOfWays = tiling2x1(n);
        System.out.println(noOfWays);
    }
    private static int tiling2x1(int n){
        // f(n) = 2 * n
        
        int[] dp = new int[n + 1];
        dp[1] = 1; // 2 * 1
        dp[2] = 2; // 2 * 2
        
        for(int i = 3; i <= n; i++){
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}