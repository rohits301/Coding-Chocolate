import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int k = scn.nextInt();

        long ans = partInKSubsets(n, k);
        System.out.println(ans);
    }

    // long since, multiply hence value badi hai
    private static long partInKSubsets(int n, int k) {
        long[][] dp = new long[k + 1][n + 1];

        for (int t = 1; t <= k; t++) {
            for (int p = 1; p <= n; p++) {
                if (t == 1) {
                    dp[t][p] = 1;
                } else if (t == p) {
                    dp[t][p] = 1;
                } else if (p < t) {
                    dp[t][p] = 0;
                } else {
                    dp[t][p] = dp[t][p - 1] * t + dp[t - 1][p - 1];
                }
            }
        }
        return dp[k][n];
    }
}