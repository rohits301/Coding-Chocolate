import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        // int ans = climbStairs(n, 0); // * can be solved as stairPaths also, same,
        // just
        // * direction opposite hai
        // System.out.println(ans);

        // int[] qb = new int[n + 1];
        // int dpcs = climbStairsMemoized(n, 0, qb);
        // System.out.println(dpcs);
        // print(qb);

        // int[] qb = new int[n + 1];
        // int dpcs = climbStairsMemoized2(n, qb); // * doing the stair path way
        // System.out.println(dpcs);
        // print(qb);

        int dpTab = climbStairsTab(n);
        System.out.println(dpTab);
    }

    public static void print(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static int climbStairs(int n, int currentPosition) {

        if (currentPosition == n) {
            return 1;
        }

        if (currentPosition > n) {
            return 0;
        }

        int jump_step_1 = climbStairs(n, currentPosition + 1);
        int jump_step_2 = climbStairs(n, currentPosition + 2);
        int jump_step_3 = climbStairs(n, currentPosition + 3);

        return jump_step_1 + jump_step_2 + jump_step_3;
    }

    public static int climbStairsMemoized(int n, int currentPosition, int[] qb) {

        if (currentPosition == n) {
            qb[currentPosition] = 1;
            return 1;
        }

        if (currentPosition > n) {
            return 0;
        }

        if (qb[currentPosition] != 0) {
            return qb[currentPosition];
        }

        int jump_step_1 = climbStairsMemoized(n, currentPosition + 1, qb);
        int jump_step_2 = climbStairsMemoized(n, currentPosition + 2, qb);
        int jump_step_3 = climbStairsMemoized(n, currentPosition + 3, qb);

        qb[currentPosition] = jump_step_1 + jump_step_2 + jump_step_3;
        return jump_step_1 + jump_step_2 + jump_step_3;
    }

    public static int climbStairsMemoized2(int n, int[] qb) {

        if (n == 0) {
            qb[n] = 1;
            return 1;
        }

        if (n < 0) {
            return 0;
        }

        if (qb[n] != 0) {
            return qb[n];
        }

        int nm1 = climbStairsMemoized2(n - 1, qb);
        int nm2 = climbStairsMemoized2(n - 2, qb);
        int nm3 = climbStairsMemoized2(n - 3, qb);
        int countPaths = nm1 + nm2 + nm3;

        qb[n] = countPaths;
        return countPaths;
    }

    public static int climbStairsTab(int n) {
        int[] dp = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            if (i == 0) {
                dp[0] = 1;
            } else if (i == 1) {
                dp[i] += dp[i - 1];
            } else if (i == 2) {
                dp[i] += dp[i - 1] + dp[i - 2];
            } else {
                dp[i] += dp[i - 1] + dp[i - 2] + dp[i - 3];
            }
        }
        // print(dp);
        return dp[n];
    }
}