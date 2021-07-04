import java.io.*;
import java.util.*;

public class Main {

    public static int solution(String str1, String str2) {
        // write your code here

        int n = str1.length();
        int m = str2.length();
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else {
                    if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        int rep = dp[i - 1][j - 1];
                        int del = dp[i][j - 1];
                        int insert = dp[i - 1][j];

                        dp[i][j] = 1 + Math.min(rep, Math.min(del, insert));
                    }
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s1 = scn.next();
        String s2 = scn.next();
        System.out.println(solution(s1, s2));
    }

}