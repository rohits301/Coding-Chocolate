import java.util.*;
import java.io.*;

public class Main {

    // T: O(n + m), S: O(n + m)
    public static double find(int[] a1, int[] a2) {
        // write your code here

        int n = a1.length;
        int m = a2.length;
        int[] merged = new int[n + m];

        int i = 0, j = 0, k = 0;

        while (i < n && j < m) {
            if (a1[i] < a2[j]) {
                merged[k++] = a1[i++];
            } else {
                merged[k++] = a2[j++];
            }
        }
        while (i < n) {
            merged[k++] = a1[i++];
        }
        while (j < m) {
            merged[k++] = a2[j++];
        }

        double median = 0.0;
        int mid = merged.length / 2;

        if (merged.length % 2 == 0) {
            // int/int is integer only,
            // hence take 2.0 to get decimal point in ans
            median = (merged[mid] + merged[mid - 1]) / 2.0;
        } else {
            median = merged[mid];
        }

        return median;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        // input work
        int n1 = scn.nextInt();
        int[] a = new int[n1];

        for (int i = 0; i < n1; i++) {
            a[i] = scn.nextInt();
        }

        int n2 = scn.nextInt();
        int[] b = new int[n2];

        for (int i = 0; i < n2; i++) {
            b[i] = scn.nextInt();
        }

        double median = find(a, b);
        System.out.println(median);
    }
}