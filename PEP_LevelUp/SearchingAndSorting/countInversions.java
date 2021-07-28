import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        // write your code here

        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        mergeSort(arr, 0, n - 1);
        System.out.println(count);
    }

    static int count = 0;

    private static int[] mergeSort(int[] arr, int lo, int hi) {

        if (lo == hi) {
            int[] base = new int[1];
            base[0] = arr[lo];
            return base;
        }

        int mid = lo + (hi - lo) / 2;

        int[] left = mergeSort(arr, lo, mid);
        int[] right = mergeSort(arr, mid + 1, hi);
        int[] merged = merge2SortedArrays(left, right);

        return merged;
    }

    private static int[] merge2SortedArrays(int[] left, int[] right) {
        int i = 0;
        int j = 0;
        int k = 0;

        int[] merged = new int[left.length + right.length];

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                merged[k++] = left[i++];
            } else {
                count += (left.length - i);
                merged[k++] = right[j++];
            }
        }

        while (i < left.length) {
            merged[k++] = left[i++];
        }

        while (j < right.length) {
            merged[k++] = right[j++];
        }

        return merged;
    }
}