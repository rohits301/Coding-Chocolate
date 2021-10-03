import java.io.*;
import java.util.*;

public class Main {
    public static void radixSort(int[] arr) {
        // write code here
        int max = Integer.MIN_VALUE;
        for (int val : arr) {
            if (max < val) {
                max = val;
            }
        }

        int exp = 1;
        while (exp <= max) {
            countSort(arr, exp);
            exp *= 10;
        }
    }

    public static void countSort(int[] arr, int exp) {
        int[] sortedArray = new int[arr.length];

        int size = 10; // range
        int[] frequencyArray = new int[size];

        // fill the frequency array
        for (int val : arr) {
            frequencyArray[val / exp % 10]++;
        }
        // find the prefixSum
        frequencyArray[0] = frequencyArray[0] - 1; // -1 is specific to this question
        for (int i = 1; i < size; i++) {
            frequencyArray[i] = frequencyArray[i - 1] + frequencyArray[i];
        }

        // back traversal, fill sortedArray
        for (int i = arr.length - 1; i >= 0; i--) {
            int val = arr[i];
            int idx = frequencyArray[val / exp % 10];

            sortedArray[idx] = val;
            frequencyArray[val / exp % 10]--;
        }

        // IMPORTANT TO TAKE SEPARATE ARRAY
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sortedArray[i];
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