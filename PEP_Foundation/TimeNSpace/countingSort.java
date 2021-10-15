import java.io.*;
import java.util.*;

public class Main {

    // T: O(n+k), S: O(n+k), n=arr.length, k=range
    public static void countSort(int[] arr, int min, int max) {
        // PRODUCTION LEVEL CODE

        int[] sortedArray = new int[arr.length];

        int range = max - min + 1;
        int[] farr = new int[range]; // frequency arr

        // 1. fill the frequency array

        for (int val : arr) {
            int fidx = val - min;
            farr[fidx]++;
        }

        // 2. fill the freq. arr with prefix sum - 1
        
        int ps = 0; // prefix sum
        for (int i = 0; i < farr.length; i++) {
            ps += farr[i];
            farr[i] = ps - 1; // -1 for index
        }
        // Now it contains last index where value appears

        // 3. back traversal of arr and fill sortedArray

        for (int i = arr.length - 1; i >= 0; i--) {
            int fidx = arr[i] - min;
            int fval = farr[fidx];

            sortedArray[fval] = arr[i];
            farr[fidx]--;
        }

        // * IMPORTANT TO TAKE SEPARATE ARRAY
        // 4. copy back to original arr

        for (int i = 0; i < arr.length; i++) {
            arr[i] = sortedArray[i];
        }

    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        countSort(arr, min, max);
        print(arr);
    }

}