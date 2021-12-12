import java.io.*;
import java.util.*;

public class Main {

    public static int solution(String str) {
        // write your code here

        int n = str.length();
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {

                // string indices-> i-1 and j-1
                if (str.charAt(i - 1) == str.charAt(j - 1) && i != j) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        // for (int[] ar : dp) {
        //     for (int val : ar) {
        //         System.out.print(val + " ");
        //     }
        //     System.out.println();
        // }

        return dp[n][n];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        System.out.println(solution(str));
    }

}