import java.util.*;

public class Main {

    // ~~~~~~~~~~~~~~~User Section~~~~~~~~~~~~~~~~~
    // T: O(n), S: O(n), passed on LeetCode
    public static int maxChunksToSorted2(int[] arr) {
        // write your code here

        // 1. Generate rmin
        int[] rmin = new int[arr.length + 1];
        // length= arr.length+1, to avoid handling extra case, 
        // since rmin[i+1] is checked every time

        rmin[arr.length] = Integer.MAX_VALUE;
        for (int i = arr.length - 1; i >= 0; i--) {
            rmin[i] = Math.min(rmin[i + 1], arr[i]);
        }

        // 2. Generate lmax and count

        int count = 0; // chunk count
        int lmax = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            lmax = Math.max(lmax, arr[i]);

            if (lmax <= rmin[i + 1]) {
                count++;
            }
        }
        return count;
    }

    // ~~~~~~~~~~~~~~~Input Management~~~~~~~~~~~~~~~~~
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }

        int res = maxChunksToSorted2(arr);
        System.out.println(res);
    }
}