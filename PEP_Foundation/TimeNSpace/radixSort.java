import java.io.*;
import java.util.*;

public class Main {

    // T: O(n * b), S: O(n), since k = 10
    // b = no. of digits in maximum value
    public static void radixSort(int[] arr) {
        // write code here

        int max = Integer.MIN_VALUE;
        for (int val : arr) {
            max = Math.max(max, val);
        }

        int exp = 1;
        while (exp <= max) {
            countSort(arr, exp);
            exp *= 10;
        }
    }

    public static void countSort(int[] arr, int exp) {
        // write code here

        int[] ans = new int[arr.length];

        int[] farr = new int[10]; // range = 9 - 0 + 1 = 10

        // 1. freq. array
        for (int i = 0; i < arr.length; i++) {
            int fidx = arr[i] / exp % 10; // * extract digit *
            farr[fidx]++;
        }

        // 2. prefix sum, farr contains index now
        int ps = 0;
        for (int i = 0; i < farr.length; i++) {
            ps += farr[i];
            farr[i] = ps - 1;
        }

        // 3. back traversal
        for (int i = arr.length - 1; i >= 0; i--) {
            int fidx = arr[i] / exp % 10;
            int fval = farr[fidx]; // index of last location for arr[i]

            ans[fval] = arr[i];
            farr[fidx]--;
        }

        // 4. copy to original arr
        for (int i = 0; i < arr.length; i++) {
            arr[i] = ans[i];
        }

        System.out.print("After sorting on " + exp + " place -> ");
        print(arr);
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        radixSort(arr);
        print(arr);
    }

}