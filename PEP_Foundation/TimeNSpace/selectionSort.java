import java.io.*;
import java.util.*;

public class Main {

    public static void selectionSort(int[] arr) {
        // write your code here

        // *REMEMBER*-> EACH time, 'i' is assumed as min, then j runs from i + 1 to
        // length
        // we compare 'min' AND 'j', then if j < min, then, min = j
        // after inner loop, swap 'min' and 'i'

        // n - 1 iterations to sort the array
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (isSmaller(arr, j, minIndex)) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
            // print(arr); // array after each iteration
        }
    }

    // used for swapping ith and jth elements of array
    public static void swap(int[] arr, int i, int j) {
        System.out.println("Swapping " + arr[i] + " and " + arr[j]);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // return true if ith element is smaller than jth element
    public static boolean isSmaller(int[] arr, int i, int j) {
        System.out.println("Comparing " + arr[i] + " and " + arr[j]);
        if (arr[i] < arr[j]) {
            return true;
        } else {
            return false;
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
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        selectionSort(arr);
        print(arr);
    }

}