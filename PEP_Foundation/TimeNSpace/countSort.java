import java.io.*;
import java.util.*;

public class Main {

    public static void countSort(int[] arr, int min, int max) {
        // PRODUCTION LEVEL CODE

        int[] sortedArray = new int[arr.length];

        int size = max - min + 1; // range
        int[] frequencyArray = new int[size];
        int[] prefixSumArray = new int[size];

        // fill the frequency array
        for (int val : arr) {
            frequencyArray[val - min]++;
        }
        // print(frequencyArray);
        // fill the prefix Sum array
        prefixSumArray[0] = frequencyArray[0] - 1; // -1 is specific to this question
        for (int i = 1; i < size; i++) {
            prefixSumArray[i] = prefixSumArray[i - 1] + frequencyArray[i];
        }
        // System.out.println("hey!");
        // print(prefixSumArray);

        // back traversal, fill sortedArray
        for (int i = arr.length - 1; i >= 0; i--) {
            int val = arr[i];
            int idx = prefixSumArray[val - min];

            sortedArray[idx] = val;
            prefixSumArray[val - min]--;
        }

        // IMPORTANT TO TAKE SEPARATE ARRAY
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