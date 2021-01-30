import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        int[] wts = new int[n];
        int[] val = new int[n];

        for (int i = 0; i < n; i++) {
            val[i] = scn.nextInt();
        }
        for (int i = 0; i < n; i++) {
            wts[i] = scn.nextInt();
        }

        int cap = scn.nextInt();

        int ans = unboundedKS(wts, val, cap);
        System.out.println(ans);
    }

    private static int unboundedKS(int[] wts, int[] val, int cap) {
        int[] dp = new int[cap + 1];

        for (int i = 1; i <= cap; i++) {
            for (int j = 0; j < wts.length; j++) {
                if (i - wts[j] >= 0) {
                    dp[i] = Math.max(dp[i - wts[j]] + val[j], dp[i]);
                }
            }
        }
        return dp[cap];
    }
}