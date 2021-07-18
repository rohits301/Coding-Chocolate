import java.io.*;
import java.util.*;

public class Main {
    public static void display(int[] a) {
        StringBuilder sb = new StringBuilder();

        for (int val : a) {
            sb.append(val + " ");
        }
        System.out.println(sb);
    }

    public static void reverse(int[] a, int l, int r) {
        while (l < r) {
            int temp = a[l];
            a[l] = a[r];
            a[r] = temp;

            l++;
            r--;
        }
    }

    public static void rotate(int[] a, int k) {
        // write your code here
        int n = a.length;

        k = k % n; // for values greater than n, use modulo

        k = (k >= 0) ? k : n + k; // for negative values

        reverse(a, 0, n - k - 1);
        // display(a);
        reverse(a, n - k, n - 1);
        // display(a);
        reverse(a, 0, n - 1);
        // display(a);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }
        int k = Integer.parseInt(br.readLine());

        rotate(a, k);
        display(a);
    }

}