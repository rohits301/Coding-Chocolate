import java.io.*;
import java.util.*;

public class Main {

    static String max;

    static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void findMaximum(char[] arr, int k) {
        // write your code here

        String str = new String(arr); // string of char array
        // using compareto saves from NumberFormatException
        // in using Interger.parseInt()

        if (max.compareTo(str) < 0) {
            max = str;
        }

        if (k == 0)
            return; // bc
        // base case is written after comparing so that
        // if any updation at k=0 is also included

        // 2 loops
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {

                if (arr[j] > arr[i]) {
                    // swap and try
                    swap(arr, i, j);
                    findMaximum(arr, k - 1);
                    swap(arr, i, j); // undo the change
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int k = scn.nextInt();
        max = str;
        // findMaximum(str, k); // given signature
        findMaximum(str.toCharArray(), k);
        System.out.println(max);
    }

}