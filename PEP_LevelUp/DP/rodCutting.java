import java.io.*;
import java.util.*;

public class Main {

    public static int solution(int[] prices) {
        // write your code here

        int n = prices.length;
        int[] dp = new int[n + 1];

        for (int i = 1; i < dp.length; i++) {
            dp[i] = prices[i - 1]; // dp[i] maps to prices[i - 1]
            int max = 0;

            for (int j = 1; j <= i; j++) {
                max = Math.max(max, prices[j - 1] + dp[i - j]);
            }
            dp[i] = max;
        }

        // for(int val : dp){
        //     System.out.print(val + " ");
        // }
        // System.out.println();
    
        return dp[n];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] prices = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = scn.nextInt();
        }
        System.out.println(solution(prices));
    }

}