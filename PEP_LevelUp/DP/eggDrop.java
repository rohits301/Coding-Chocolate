import java.io.*;
import java.util.*;

public class Main {

    public static int eggDrop(int n, int k) {
        // write your code here

        // T : O(n^2 * e)
        // n eggs, k floors

        int[][] dp = new int[n + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                if (i == 1) {
                    dp[i][j] = j; // try from all floors
                } else if (j == 1) {
                    dp[i][j] = 1; // only 1 egg needed, 1 try
                } else {
                    int min = Integer.MAX_VALUE;
                    
                    for (int currj = j - 1, prevj = 0; currj >= 0; currj--, prevj++) {
                        int v1 = dp[i][currj]; // survives
                        int v2 = dp[i - 1][prevj]; // breaks
                        int val = Math.max(v1, v2); // max(worst) of luck
                        min = Math.min(min, val); // best(min) of the choices
                    }
                    dp[i][j] = min + 1;
                }
            }
        }

        return dp[n][k];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        // n -> number of eggs and k -> number of floors
        int n = scn.nextInt();
        int k = scn.nextInt();
        System.out.println(eggDrop(n, k));
    }

}