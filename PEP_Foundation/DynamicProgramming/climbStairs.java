import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        // int ans = climbStairs(n, 0); // * can be solved as stairPaths also, same, just
        // * direction opposite hai
        // System.out.println(ans);

        int[] qb = new int[n + 1];
        int dpcs = climbStairsMemoized(n, 0, qb);
        System.out.println(dpcs);

        // print(qb);
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

    // TODO: public static int climbStairsTab(int n, int currentPosition)
}