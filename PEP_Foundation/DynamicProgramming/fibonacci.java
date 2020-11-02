/*
! Using memoization
Calculating fibonacci of 6
Calculating fibonacci of 5
Calculating fibonacci of 4
Calculating fibonacci of 3
Calculating fibonacci of 2
8
*/

/* 
! Without memoization
* Notice the repetition
Calculating fibonacci of 6
Calculating fibonacci of 5
Calculating fibonacci of 4
Calculating fibonacci of 3
Calculating fibonacci of 2
Calculating fibonacci of 2
Calculating fibonacci of 3
Calculating fibonacci of 2
Calculating fibonacci of 4
Calculating fibonacci of 3
Calculating fibonacci of 2
Calculating fibonacci of 2
8
*/

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // write your code here

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        // int ans = fib(n); // gives TLE on other editors, t = 3.29ms
        // System.out.println(ans);

        int dpFib = fibMemoized(n, new int[n + 1]); // t = 0.99ms
        System.out.println(dpFib);
    }

    public static int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        // System.out.println("Calculating fibonacci of " + n);
        int fibnm1 = fib(n - 1); // fibonacci of n - 1
        int fibnm2 = fib(n - 2); // fibonacci of n - 2

        int fibn = fibnm1 + fibnm2; // fibonacci of n

        return fibn;
    }

    public static int fibMemoized(int n, int[] questionBank) {
        if (n == 0 || n == 1) {
            return n;
        }

        // * if questionBank has answer, then return that answer
        if (questionBank[n] != 0) {
            return questionBank[n];
        }

        // System.out.println("Calculating fibonacci of " + n);
        int fnm1 = fibMemoized(n - 1, questionBank);
        int fnm2 = fibMemoized(n - 2, questionBank);
        int fibn = fnm1 + fnm2;

        questionBank[n] = fibn; // ** this turns on dp **
        return fibn;
    }
}